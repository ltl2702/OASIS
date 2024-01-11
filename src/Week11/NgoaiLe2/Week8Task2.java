import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class demonstrates various exceptions and their handling.
 */
public class Week8Task2 {
    /**
     * Simulates a NullPointerException.
     */
    public void nullPointerEx() {
        String str = null;
        str.length();
    }

    /**
     * Tests the nullPointerEx method.
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
            return "Không có lỗi";
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
    }

    /**
     * Simulates an ArrayIndexOutOfBoundsException.
     */
    public void arrayIndexOutOfBoundsEx() {
        int[] arr = new int[100];
        arr[101] = 100;
    }

    /**
     * Tests the arrayIndexOutOfBoundsEx method.
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
            return "Không có lỗi";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
    }

    /**
     * Simulates an ArithmeticException.
     */
    public void arithmeticEx() {
        int x = 10 / 0;
    }

    /**
     * Tests the arithmeticEx method.
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
            return "Không có lỗi";
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
    }

    /**
     * Simulates a FileNotFoundException.
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\PC\\linh.txt");
    }

    /**
     * Tests the fileNotFoundEx method.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
            return "Không có lỗi";
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
    }

    /**
     * Simulates an IOException.
     */
    public void ioEx() throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\PC\\linh.txt");
    }

    /**
     * Tests the ioEx method.
     */
    public String ioExTest() {
        try {
            ioEx();
            return "Không có lỗi";
        } catch (IOException e) {
            return "Lỗi IO";
        }
    }

    /**
     * Main.
     */
    public static void main(String[] args) {
        Week8Task2 k = new Week8Task2();
        System.out.println(k.nullPointerExTest());
        System.out.println(k.arrayIndexOutOfBoundsExTest());
        System.out.println(k.arithmeticExTest());
        System.out.println(k.fileNotFoundExTest());
        System.out.println(k.ioExTest());
    }
}
