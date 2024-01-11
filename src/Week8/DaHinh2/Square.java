import java.util.Objects;

public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        this.width = side;
        this.length = side;
    }

    /** An especially short bit of Javadoc. */
    public Square(double side, String color, boolean filled) {
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    /** An especially short bit of Javadoc. */
    public Square(Point topLeft, double side, String color, boolean filled) {
        this.topLeft = topLeft;
        this.width = side;
        this.length = side;
        this.color = color;
        this.filled = filled;
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double side) {
        this.length = side;
        this.width = side;
    }

    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /** An especially short bit of Javadoc. */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Square)) {
            return false;
        }
        Square oth = (Square) o;

        return Math.abs(this.width - oth.width) <= 0.001
                && Math.abs(this.length - oth.length) <= 0.001;
    }


    public int hashCode() {
        return super.hashCode();
    }

    /** An especially short bit of Javadoc. */
    public String toString() {
        return "Square[topLeft=(" + String.format("%.1f", topLeft.getPointX())
                +  "," + String.format("%.1f", topLeft.getPointY()) + "),"
                + "side=" + this.width + ",color=" + color + ",filled=" + filled + ']';
    }


}
