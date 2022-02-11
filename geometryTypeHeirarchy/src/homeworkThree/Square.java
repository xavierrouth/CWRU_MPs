package homeworkThree;
/**
 * Xavier Routh
 * Square class that represents a square polygon
 */
public class Square extends NGon implements RegularPolygon{
    // Fields for width and height
    private double width;
    private double height;
    /** Constructor
     * calls the super constructor of NGon with 4 sides
     * @param center the center point of the square
     * @param sideLength the side length of the square
     */
    public Square(Point center, double sideLength) {
        super(center, 4, sideLength);
    }
    /**
     * @param sideLength Sets the side length of the square
     */
    public void setWidth(double sideLength) {
        this.setHeight(sideLength);
    }
    /**
     * @param sideLength Sets the side length of the square
     */
    public void setHeight(double sideLength) {
        this.height = sideLength;
        this.width = sideLength;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
}