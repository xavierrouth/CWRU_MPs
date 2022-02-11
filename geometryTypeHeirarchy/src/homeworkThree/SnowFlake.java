package homeworkThree;
import java.io.*;
import java.util.*;
/**
 * Xavier Routh
 * Class that represents a snowFlake fractal
 */
public class SnowFlake extends Polygon{
    // Stores the base shape and the number of levels of the
    private RegularPolygon baseShape;
    private int numLevels;
    /** Construcotr
     * @param baseShape the base shape that makes up the beginning of the fractal
     * @param numLevels the number of levels deep the fractal should go
     */
    public SnowFlake(RegularPolygon baseShape, int numLevels) {
        this.numLevels = numLevels;
        this.center = baseShape.getCenter();
        this.lines = baseShape.getLines();
        this.points = baseShape.getPoints();
        // Two lists that store the lines and points that make up our fractal.
        // Kind of like stringBuilder in that you can append to the end of them.
        ArrayList<Point> pointsArrayBuilder = new
                ArrayList<Point>(Arrays.asList(baseShape.getPoints()));
        ArrayList<Line> lineArray = new
                ArrayList<Line>(Arrays.asList(baseShape.getLines()));
        // Loop through this while we still have levels to go
        while (numLevels != 0) {
            // Go through all our lines and split them into 4 smaller lines
            for (int i = 0; i < lineArray.size(); i++) {
                Line startLine = lineArray.get(i);
                double y2 = startLine.getSecondPoint().getY();
                double y1 = startLine.getFirstPoint().getY();
                double x2 = startLine.getSecondPoint().getX();
                double x1 = startLine.getFirstPoint().getX();
                double xDistance = x2 - x1;
                double yDistance = y2 - y1;
                double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2
                        - x1));
                Line l1 = new Line(startLine.getFirstPoint(), new
                        Point(startLine.getFirstPoint().getX() + xDistance / 4.0,
                        startLine.getFirstPoint().getY() + yDistance / 4.0));
                Point point = new Point(x1 + xDistance / 2.0, y1 + yDistance /
                        2.0);
                point.rotateAbout(l1.getFirstPoint(), Math.PI / 3.0);
                Line l2 = new Line(l1.getFirstPoint(), point);
                Point point2 = new Point(x2 - xDistance / 4.0, y2 - yDistance /
                        4.0);
                Line l3 = new Line(l2.getSecondPoint(), point2);
                Line l4 = new Line(l3.getFirstPoint(), startLine.getSecondPoint());
                lineArray.add(l1);
                lineArray.add(l2);
                lineArray.add(l3);
                lineArray.add(l4);
            }
            // We went through all the lines, time to go to another level.
            numLevels--;
        }
        // Add all the points into our points array
        for (int i = 0; i < lineArray.size(); i++) {
            pointsArrayBuilder.add(lineArray.get(i).getSecondPoint());
        }
        // Set our class fields to the point arraylist and line arraylist
        this.points = pointsArrayBuilder.toArray(new Point[0]);
        this.lines = lineArray.toArray(new Line[0]);
    }
    /**
     * @return gets the number of levels
     */
    public int getNumLevels() {
        return numLevels;
    }
    /**
     * @param numLevels Sets the number of levels (doesn't work)
     */
    public void setNumLevels(int numLevels) {
        new SnowFlake(this.getBaseShape(), this.getNumLevels());
        this.numLevels = numLevels;
    }
    /**
     * @return Returns the base shape this fractal is made of.
     */
    public RegularPolygon getBaseShape() {
        return this.baseShape;
    }
}