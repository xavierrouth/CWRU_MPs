package homeworkThree;
import java.lang.Math.*;
/**
 * Xavier Routh
 * A class that represents a point
 */
public class Point {
    // Variables to store the x and y of the point
    private double x;
    private double y;
    /**
     * Construcotr
     * @param x stores x position
     * @param y stores y position
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * @return gets x
     */
    public double getX() {
        return x;
    }
    /**
     * @param x sets x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * @return gets y
     */
    public double getY() {
        return y;
    }
    /**
     * @param y sets y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * Rotates the point about another point a certain amount of radians.
     * @param point the point that it should be rotated about
     * @param angle the angle of rotation
     */
    public void rotateAbout(Point point, double angle) {
        double newX = ((Math.cos(angle) * (this.getX() - point.getX())) -
                (Math.sin(angle) * (this.getY() - point.getY())) + point.getX());
        double newY = ((Math.sin(angle) * (this.getX() - point.getX())) +
                (Math.cos(angle) * (this.getY() - point.getY())) + point.getY());
        this.setX(newX);
        this.setY(newY);
    }
}