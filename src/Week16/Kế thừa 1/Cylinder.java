public class Cylinder extends Circle {
    private double height; // The height of the cylinder

    /**
     * Default constructor.
     */
    public Cylinder() {
    }

    /**
     * Constructor creates a cylinder with the specified height.
     *
     * @param height The height of the cylinder.
     */
    public Cylinder(double height) {
        this.height = height;
    }

    /**
     * Constructor creates a cylinder with the specified height and radius.
     *
     * @param height The height of the cylinder.
     * @param radius The radius of the cylinder.
     */
    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    /**
     * Constructor creates a cylinder with the specified height, radius, and color.
     *
     * @param height The height of the cylinder.
     * @param radius The radius of the cylinder.
     * @param color  The color of the cylinder.
     */
    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    /**
     * Get the height of the cylinder.
     *
     * @return The height of the cylinder.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Set the height of the cylinder.
     *
     * @param height The new height of the cylinder.
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Calculate and return the volume of the cylinder.
     *
     * @return The volume of the cylinder.
     */
    public double getVolume() {
        return PI * getRadius() * getRadius() * height;
    }

    /**
     * Return a string representation of the cylinder.
     *
     * @return A string representation of the cylinder.
     */
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }

    /**
     * Calculate and return the surface area of the cylinder.
     *
     * @return The surface area of the cylinder.
     */
    public double getArea() {
        return 2 * PI * getRadius() * (getRadius() + height);
    }
}
