package homeworkThree;
/** Xavier Routh
 * Triangle class that represents a trianlge
 */
public class Triangle extends Polygon{
    /**
     * @param points the points that make up the triangle
     */
    public Triangle(Point... points) {
        super();
        // makes sure we only have three points in a triangle
        if (points.length != 3) {
            throw new IllegalArgumentException();
        }
        this.points = points;
        this.initializeLines();
        // Two lines that go from verticies to the midpoint of the opposite side
        Line l1 = new Line(points[0], lines[1].findMidPoint());
        Line l2 = new Line(points[1], lines[2].findMidPoint());
        // The center is defined as where these lines intersect
        this.center = Line.calculateIntersection(l1, l2);
    }
}