
package homeworkThree;
/**
 * Xavier Routh
 * Equilateral Triangle Class,
 */
public class EquilateralTriangle extends NGon implements RegularPolygon{
    /**
     * Constructor
     * Creates an equilateral triangle with a center and a side length
     * @param center Represents the center of the triangle
     * @param sideLength Represents the length of one of the sides
     */
    public EquilateralTriangle(Point center, double sideLength) {
        // Calls the super constructor for NGon class
        super(center, 3, sideLength);
    }
}
