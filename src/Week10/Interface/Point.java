public class Point {
    private double pointX;
    private double pointY;

    public Point(double x, double y) {
        this.pointX = x;
        this.pointY = y;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double x) {
        this.pointX = x;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double y) {
        this.pointY = y;
    }

    /**
     * calculates the distance between 2 point.
     *
     * @param other The other point
     * @return the distance between the current point and the other point
     */
    public double distance(Point other) {
        double dx = this.pointX - other.pointX;
        double dy = this.pointY - other.pointY;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
