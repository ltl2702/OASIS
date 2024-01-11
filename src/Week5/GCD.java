// Import your library
// Do not change the name of the Solution class
public class GCD {
    // Type your main code here
    /**
     * Returns the greatest common divisor of two integer numbers.
     * Returns an integer.
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1; // You might want to return 1 if there is no common divisor other than 1.
    }
    /*
    public class Solution {
    public static int gcd(int a, int b) {
        if (a == 0) {
            if (b >= 0) {
                return b;
            } else {
                return -b;
            }
        }
        return gcd(b % a, a);
    }
}
 */
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(gcd(a,b));
    }
}