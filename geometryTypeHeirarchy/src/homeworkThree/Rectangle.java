package homeworkThree;
/**
 * Xavier Routh
 * rectangle is a polygon that has 2 sets of parallel sides
 * represents a rectange
 */
public class Rectangle extends Polygon {
    // Two variables that store the width and the height of the rectangle
    protected double width;
    protected double height;

    /**
     * @param center The center point of the rectangle
     * @param height The height of the rectangle
     * @param width  The width of the rectangle
     */
    public Rectangle(Point center, double height, double width) {
        super();
        // Initializes the points of the rectangle
        this.points = new Point[]
                {
                        new Point(center.getX() - this.width / 2.0, center.getY() -
                                this.height / 2.0),
                        new Point(center.getX() + this.width / 2.0, center.getY() -
                                this.height / 2.0),
                        new Point(center.getX() + this.width / 2.0, center.getY() +
                                this.height / 2.0),
                        new Point(center.getX() - this.width / 2.0, center.getY() +
                                this.height / 2.0)
                };
        super.initializeLines();
    }

    /**
     * @param width the width of the rectangle
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return Returns the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param height the height of the rectangle
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return returns the height
     */
    public double getHeight() {
        return height;
    }
}