package homeworkThree;
/**
 * Xavier Routh
 * a class that represents a polygon
 */
public class Polygon {
    // The center point
    protected Point center = null;
    // Arrays that store both the points and the lines that make up the shape;
    protected Point[] points = null;
    protected Line[] lines = null;
    // Empty constructor so we don't get confused with the vargs constructor
    public Polygon() {
    }
    /**
     * Constructor
     * @param points An array of points that make up our polygon
     */
    public Polygon(Point... points) {
        // If we have less than three points, warn the user.
        if (points.length < 3) {
            throw new IllegalArgumentException();
        }
        this.points = points;
        int numPoints = this.points.length;
        // Variables that store the maximum and minimum x and y values
        double maxX = points[0].getX();
        double minX = points[0].getX();
        double maxY = points[0].getY();
        double minY = points[0].getY();
        // Loop through all the points and find the maximum and minimum values for
        // x and y
        for (int i = 0; i < numPoints; i++) {
            if (points[i].getX() > maxX) {
                maxX = points[i].getX();
            }
            if (points[i].getX() < minX) {
                minX = points[i].getX();
            }
            if (points[i].getY() > maxY) {
                maxY = points[i].getY();
            }
            if (points[i].getY() < minY) {
                minY = points[i].getY();
            }
        }
        // Set the center to the middle of the bounding rectangle
        this.center = new Point(((maxX - minX) / 2.0) + minX, ((maxY - minY) / 2.0)
                + minY);
        this.initializeLines();
    }
    /**
     * Connects all the points together and creates lines in between them
     */
    public void initializeLines() {
        if (this.points.length == 0) {
            return;
        }
        int numPoints = this.points.length;
        // Initialize lines
        lines = new Line[numPoints];
        // Loop through all the points but the last one.
        for (int i = 0; i < numPoints - 1; i++) {
            // Connect two sequential points together
            lines[i] = new Line(points[i], points[i+1]);
        }
        // Connect the last point to the first point
        lines[numPoints - 1] = new Line(points[numPoints - 2], points[0]);
    }
    /**
     * Rotates the entire polygon about its center by a certain amount of radians
     * @param angle Angle of rotation
     */
    public void Rotate(double angle) {
        for (int i = 0; i < this.points.length; i++) {
            points[i].rotateAbout(this.center, angle);
        }
    }
    /**
     * @return Returns the center
     */
    public Point getCenter() {
        return center;
    }
    /**
     * sets the center to a new place
     * @param newCenter the new center of the polygon
     */
    public void setCenter(Point newCenter) {
        // Values that determine how much we need to move our center by to get it
        // back to the correct spot
        double xDifference = newCenter.getX() - this.center.getX();
        double yDifference = newCenter.getY() - this.center.getY();
        // Move each point by the amount the center has moved.
        for (int i = 0; i < this.points.length; i++) {
            points[i].setX(points[i].getX() + xDifference);
            points[i].setY(points[i].getY() + yDifference);
        }
        this.center = newCenter;
    }
    /**
     * @return returns the points
     */
    public Point[] getPoints() {
        return this.points;
    }
    /**
     * @return returns the lines
     */
    public Line[] getLines() {
        return this.lines;
    }
}