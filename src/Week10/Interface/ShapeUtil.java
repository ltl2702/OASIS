import java.util.List;

public class ShapeUtil {
    /**
     * Generates and prints information about geometric objects in a list.
     *
     * @param shapes A list of geometric objects.
     * @return A concatenated string containing information about circles and triangles.
     */
    public String printInfo(List<GeometricObject> shapes) {
        String rs = new String();
        rs = rs + "Circle:\n";
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Circle) {
                rs = rs + shapes.get(i).getInfo() + "\n";
            }
        }
        rs = rs + "Triangle:\n";
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Triangle) {
                rs = rs + shapes.get(i).getInfo() + "\n";
            }
        }
        return rs;
    }
}
