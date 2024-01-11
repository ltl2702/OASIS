import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    /**
     * Adds a shape to the layer.
     *
     * @param shape The shape to add.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Removes all circles from the layer.
     */
    public void removeCircles() {
        ListIterator<Shape> iterator = shapes.listIterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (shape instanceof Circle) {
                iterator.remove();
            }
        }
    }

    /**
     * Retrieves information about the shapes in the layer.
     *
     * @return A string containing information about the shapes.
     */
    public String getInfo() {
        String result = "Layer of crazy shapes:\n";
        for (int i = 0; i < shapes.size(); i++) {
            result += shapes.get(i).toString() + "\n";
        }
        return result;
    }

    /**
     * Removes duplicate shapes from the layer based on their string representations.
     */
    public void removeDuplicates() {
        HashSet<Integer> set = new HashSet<Integer>();
        ListIterator<Shape> iterator = shapes.listIterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            if (set.contains(shape.hashCode())) {
                iterator.remove();
            } else {
                set.add(shape.hashCode());
            }
        }
    }
}
