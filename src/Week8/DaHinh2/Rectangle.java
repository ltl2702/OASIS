import java.util.Objects;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft;

    public Rectangle() {

    }

    /** An especially short bit of Javadoc. */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /** An especially short bit of Javadoc. */
    public Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    /** An especially short bit of Javadoc. */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    /** An especially short bit of Javadoc. */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Rectangle other = (Rectangle) o;
        return Math.abs(this.width - other.width) <= 0.001
                && Math.abs(this.length - other.length) <= 0.001;
    }


    public int hashCode() {
        return Objects.hash(width, length, topLeft);
    }


    /** An especially short bit of Javadoc. */
    public String toString() {
        return "Rectangle[topLeft=(" + String.format("%.1f", topLeft.getPointX())
                + "," + String.format("%.1f", topLeft.getPointY()) + "),"
                + "width=" + width + ",length=" + length
                + ",color=" + color + ",filled=" + filled + ']';
    }

}
