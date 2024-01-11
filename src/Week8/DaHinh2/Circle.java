import java.util.Objects;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /** An especially short bit of Javadoc. */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    /** An especially short bit of Javadoc. */
    public Circle(Point center, double radius, String color, boolean filled) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /** An especially short bit of Javadoc. */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Circle)) {
            return false;
        }
        Circle otherCircle = (Circle) o;
        return Math.abs(this.radius - otherCircle.radius) <= 0.001;
    }


    public int hashCode() {
        return Objects.hash(radius, center);
    }

    /** An especially short bit of Javadoc. */
    public String toString() {
        return "Circle[center=(" + String.format("%.1f", center.getPointX())
                + "," + String.format("%.1f", center.getPointY()) + ")," + "radius="
                + String.format("%.1f", radius) + ",color=" + color + ",filled=" + filled + ']';
    }



}
