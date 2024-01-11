public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * Constructs a triangle with three distinct points.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     * @param p3 The third point.
     * @throws RuntimeException if the points are collinear
     * or if any two points coincide.
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        if ((p1.getPointX() == p2.getPointX() && p1.getPointY() == p2.getPointY())
                || (p2.getPointX() == p3.getPointX() && p2.getPointY() == p3.getPointY())
                || (p1.getPointX() == p3.getPointX() && p1.getPointY() == p3.getPointY())) {
            throw new RuntimeException();
        }
        if (p1.distance(p2) + p2.distance(p3) == p1.distance(p3)
                || p1.distance(p3) + p2.distance(p3) == p1.distance(p3)
                || p1.distance(p2) + p1.distance(p3) == p2.distance(p3)) {
            throw new RuntimeException();
        }

    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    /**
     * Return area.
     */
    public double getArea() {
        double x = p1.distance(p2);
        double y = p2.distance(p3);
        double z = p3.distance(p1);
        double p = (x + y + z) / 2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }

    /**
     * Return perimeter.
     */
    public double getPerimeter() {
        double x = p1.distance(p2);
        double y = p2.distance(p3);
        double z = p3.distance(p1);
        return x + y + z;
    }

    /**
     * Returns a formatted triangle representation.
     */
    public String getInfo() {
        return "Triangle[(" + String.format("%.2f", p1.getPointX()) + ","
                + String.format("%.2f", p1.getPointY()) + "),("
                + String.format("%.2f", p2.getPointX()) + ","
                + String.format("%.2f", p2.getPointY()) + "),("
                + String.format("%.2f", p3.getPointX()) + ","
                + String.format("%.2f", p3.getPointY()) + ")]";
    }
}
