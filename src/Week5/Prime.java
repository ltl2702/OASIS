package Week5;

// Import your library
// Do not change the name of the Solution class
public class Prime {
    // Type your main code here
    /**
     *Tests a number is prime or not.
     *Returns true if the number is prime.
     *Returns false if the number is not prime.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(isPrime(n));
    }
}

