public class Rectangle extends Shape {
    protected double width;
    protected double length;

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

    public String toString() {
        return "Rectangle[width=" + width + ",length=" + length
        + ",color=" + color + ",filled=" + filled + ']';
    }



}
