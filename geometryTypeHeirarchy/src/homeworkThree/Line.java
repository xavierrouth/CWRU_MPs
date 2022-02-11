package homeworkThree;
/**
 * Xavier Routh
 * class that represents a line (two points)
 */
public class Line {
    // Stores the first point of the line
    private Point firstPoint;
    // Stores the second point of the line
    private Point secondPoint;
    /**
     * @param p1 the first point
     * @param p2 the second point
     */
    public Line(Point p1, Point p2) {
        this.firstPoint = p1;
        this.secondPoint = p2;
    }
    /**
     * @param p1x the x of the first point
     * @param p1y the y of the first point
     * @param p2x the x of the second point
     * @param p2y the y of the second point
     */
    public Line(double p1x, double p1y, double p2x, double p2y) {
        this(new Point(p1x, p1y), new Point(p2x, p2y));
    }
    /**
     * @return returns an array storing the lines
     */
    public Line[] getLines() {
        return (new Line[]{this});
    }
    /**
     * @return returns the first point
     */
    public Point getFirstPoint() {
        return firstPoint;
    }
    /**
     * @param firstPoint sets the first point
     */
    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }
    /**
     * @return returns the second point
     */
    public Point getSecondPoint() {
        return secondPoint;
    }
    /**
     * @param secondPoint sets the second point
     */
    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }
    /**
     * @return Finds and returns the midpoint of a line
     */
    public Point findMidPoint() {
        // Temporary variables to store the x and y values of our two points
        double x1 = this.getFirstPoint().getX();
        double x2 = this.getSecondPoint().getX();
        double y1 = this.getFirstPoint().getY();
        double y2 = this.getFirstPoint().getY();
        // Returns the midpoint
        return new Point(((x1 + x2) / 2.0), ((y1 + y2 / 2.0)));
    }
    /**
     * Calculates the intersection between two lines and returns the point
     * @param l1 the first line
     * @param l2 the second line
     * @return the point where the two lines intersect
     */
    public static Point calculateIntersection(Line l1, Line l2) {
        // Temporary variables to store the x and y values of our 4 points.
        double x1 = l1.getFirstPoint().getX();
        double y1 = l1.getFirstPoint().getY();
        double x2 = l1.getFirstPoint().getX();
        double y2 = l1.getFirstPoint().getY();
        double x3 = l2.getFirstPoint().getX();
        double y3 = l2.getFirstPoint().getY();
        double x4 = l2.getFirstPoint().getX();
        double y4 = l2.getFirstPoint().getY();
        return new Point(
                ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4))
                        / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4)),
                ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4))
                        / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4))
        );
    }
}