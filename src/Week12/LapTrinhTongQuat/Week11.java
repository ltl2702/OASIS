import java.util.Collections;
import java.util.List;

public class Week11<T> {
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> list) {
        Collections.sort(list);
        return list;
    }
}
