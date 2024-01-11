import java.util.Scanner;

public class Fibonacci {
    /**
     * Calculates the nth number in the Fibonacci sequence
     *
     * @param n the index of the number to calculate
     * @return the nth number in the Fibonacci sequence
     *          -1 if n is negative
     *          Long.Max_VALUE if n is greater than 92
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long f0 = 0;
            long f1 = 1;
            for (long i = 2; i <= n; i++) {
                long f2 = f0 + f1;
                if (f2 < 0) {
                    return Long.MAX_VALUE;
                }
                f0 = f1;
                f1 = f2;
            }
            return f1;
        }
    }
    /*
    public class Solution {
    // ... (Javadoc comments)

    public long fibonacci(long n) {
        long fn = -1L;
        long f0 = 0L;
        long f1 = 1L;
        if (n == 0) {
            return 0L;
        } else if (n < 0) {
            return fn;
        } else if (n > 92) {
            return Long.MAX_VALUE;
        } else if (n == 1) {
            return 1;
        } else {
            for (int i = 2; i <= n; i++) {
                fn = f0 + f1;
                f0 = f1;
                f1 = fn;
            }
        }
        return fn;
    }
}

     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }
}


