package homeworkThree;
/**
 * Xavier Routh
 * NGon represents any regular polygon
 */
public class NGon extends Polygon implements RegularPolygon{
    // Represents the side length
    protected double sideLength;
    // Stores the number of sides
    protected int numSides;
    /**
     * Constructor
     * @param center Stores the center of the NGon
     * @param numSides stores the number of sides
     * @param sideLength stores the length of each side
     */
    public NGon(Point center, int numSides, double sideLength) {
        this.center = center;
        this.numSides = numSides;
        this.sideLength = sideLength;
        // The central angle from two adjacent vertices, used to generate the
        //points
        double angle = 360.0 / (double) numSides;
        // The distance from the center to one of the vertices
        double xDistance = (this.getSideLength() / 2.0 * Math.sin(180.0 / (double)
                numSides));
        // Initialize the points array
        points = new Point[numSides];
        // Go through all the required sides and generate vertices for them
        for (int i = 0; i < numSides; i++) {
            points[i] = new Point(this.center.getX() + xDistance,
                    this.center.getY());
            points[i].rotateAbout(this.getCenter(), angle * i);
        }
        // Connect the vertices and create lines
        super.initializeLines();
    }
    /**
     * Resizes the polygon to a new side length while keeping all the points the
     same.
     * @param newSideLength The new side length to change the polygon to.
     */
    public void resizeRegularPolygon(double newSideLength) {
        // Create a temporary new NGon with the same center but with our new side
        // length so we can just copy the points over
        NGon newNGon = new NGon(this.getCenter(), this.getNumSides(),
                newSideLength);
        // Go through the old points and set them to the same values of the old
        // points
        for (int i = 0; i < this.points.length; i++) {
            this.points[i].setX(newNGon.points[i].getX());
            this.points[i].setY(newNGon.points[i].getY());
        }
    }
    /**
     * @return returns the side length
     */
    public double getSideLength() {
        return sideLength;
    }
    /**
     * @param newSideLength Sets the side length and resizes the polygon
     */
    public void setSideLength(double newSideLength) {
        this.resizeRegularPolygon(newSideLength);
        this.sideLength = newSideLength;
    }
    /**
     * @return Returns the number of sides
     */
    public int getNumSides() {
        return numSides;
    }
}