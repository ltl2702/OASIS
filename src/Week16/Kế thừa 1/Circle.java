/**
 * The Circle class represents a circle with a radius and color.
 */
public class Circle {
    private double radius; // The radius of the circle
    private String color; // The color of the circle
    protected static final double PI = Math.PI; // The constant PI

    /**
     * Default constructor.
     */
    public Circle() {
    }

    /**
     * Constructor creates a circle with the specified radius.
     *
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor creates a circle with the specified radius and color.
     *
     * @param radius The radius of the circle.
     * @param color  The color of the circle.
     */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    /**
     * Get the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set the radius of the circle.
     *
     * @param radius The new radius of the circle.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Get the color of the circle.
     *
     * @return The color of the circle.
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of the circle.
     *
     * @param color The new color of the circle.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Calculate and return the area of the circle.
     *
     * @return The area of the circle.
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * Return a string representation of the circle.
     *
     * @return A string representation of the circle.
     */
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }
}
