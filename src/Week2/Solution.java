package Week2;

public class Solution {
    // Type your main code here
    public String printHello() {
        return "HelloWorld";
    }

    /**
     * The main function, entry point of this app.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String sl = solution.printHello();
        System.out.println(sl);
    }
}
