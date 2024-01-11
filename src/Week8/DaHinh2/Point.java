import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /** An especially short bit of Javadoc. */
    public double distance(Point newPoint) {
        double dx = this.pointX - newPoint.pointX;
        double dy = this.pointY - newPoint.pointY;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /** An especially short bit of Javadoc. */
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Point)) {
            return false;
        }
        Point oth = (Point) o;
        return this.pointX == oth.pointX && this.pointY == oth.pointY;
    }

    public int hashCode() {
       return Objects.hash(pointX, pointY);
    }

    public String toString() {
        return "(" + pointX + "," + pointY + ")";
    }
}
