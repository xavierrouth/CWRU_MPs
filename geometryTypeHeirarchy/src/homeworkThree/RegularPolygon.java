package homeworkThree;
/**
 * Xavier Routh
 * Interface that represents all regular polygons
 * Squares, EquilateralTriangle, NGon
 */
public interface RegularPolygon {
    Point[] getPoints();
    Point getCenter();
    Line[] getLines();
}