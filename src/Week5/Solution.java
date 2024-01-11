/**
 * The Solution class represents a rational number as a numerator and a denominator.
 * It provides methods to perform basic arithmetic operations on rational numbers.
 */
public class Solution {
    private int numerator;
    private int denominator = 1;

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two integers.
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    /**
     * Constructs a new Solution object with the given numerator and denominator.
     *
     * @param numerator   The numerator of the rational number.
     * @param denominator The denominator of the rational number.
     */
    public Solution(int numerator, int denominator) {
       this.numerator = numerator;
       if (denominator != 0) {
           this.denominator = denominator;
       }
    }

    /**
     * Gets the numerator of the rational number.
     *
     * @return The numerator.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Sets the numerator of the rational number.
     *
     * @param numerator The new numerator value.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Gets the denominator of the rational number.
     *
     * @return The denominator.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Sets the denominator of the rational number.
     *
     * @param denominator The new denominator value.
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * Reduces the rational number to its simplest form.
     *
     * @return The reduced Solution object.
     */
    public Solution reduce() {
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return this;
    }

    /**
     * Adds another rational number to this rational number.
     *
     * @param other The other rational number to add.
     * @return The result of the addition as a reduced Solution object.
     */
    public Solution add(Solution other) {
        int newNumerator = this.numerator * other.denominator + this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        this.numerator = newNumerator;
        this.denominator = newDenominator;
        return this.reduce();
    }

    /**
     * Subtracts another rational number from this rational number.
     *
     * @param other The other rational number to subtract.
     * @return The result of the subtraction as a reduced Solution object.
     */
    public Solution subtract(Solution other) {
        int newNumerator = this.numerator * other.denominator - this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        this.numerator = newNumerator;
        this.denominator = newDenominator;
        return this.reduce(); // Rút gọn kết quả sau phép trừ
    }

    /**
     * Multiplies this rational number by another rational number.
     *
     * @param other The other rational number to multiply by.
     * @return The result of the multiplication as a reduced Solution object.
     */
    public Solution multiply(Solution other) {
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;
        return this.reduce();
    }

    /**
     * Divides this rational number by another rational number.
     *
     * @param other The other rational number to divide by.
     * @return The result of the division as a reduced Solution object.
     */
    public Solution divide(Solution other) {
        if (other.denominator != 0) {
            this.numerator = this.numerator * other.denominator;
            this.denominator = this.denominator * other.numerator;
        }
        return this.reduce();
    }

    /**
     * Compares this Solution object to another object for equality.
     *
     * @param obj The object to compare to.
     * @return true if the objects are equal (represent the same rational number), false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            this.reduce();
            other.reduce();
            return this.numerator == other.numerator && this.denominator == other.denominator;
        }
        return false;
    }

    /**
     * Returns a string representation of the rational number in the form "numerator/denominator".
     * If the denominator is 1, it returns only the numerator.
     *
     * @return The string representation of the rational number.
     */
    @Override
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        }
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Solution fraction1 = new Solution(1, 2); // Tạo phân số 1/2
        Solution fraction2 = new Solution(3, 4); // Tạo phân số 3/4

        // Thực hiện các phép toán
        fraction1.add(fraction2); // Cộng 1/2 + 3/4
        System.out.println("Sum: " + fraction1);

        fraction1.subtract(fraction2); // Trừ (1/2 + 3/4) - 3/4
        System.out.println("Result after subtraction: " + fraction1);

        fraction1.multiply(fraction2); // Nhân ((1/2 - 3/4) + 3/4) * 3/4
        System.out.println("Result after multiplication: " + fraction1);

        fraction1.divide(fraction2); // Chia (((1/2 - 3/4) * 3/4) * 3/4) / 3/4
        System.out.println("Result after division: " + fraction1);

        // Kiểm tra tính bằng nhau
        Solution fraction3 = new Solution(2, 4); // Tạo phân số 2/4
        System.out.println("Are fraction1 and fraction3 equal? " + fraction1.equals(fraction3));
    }
}
