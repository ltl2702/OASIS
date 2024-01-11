/**
 * Represents a numerical value in a mathematical expression.
 */
public class Numeral extends Expression {
    private double value;

    /**
     * Constructs a Numeral object with a specific numerical value.
     *
     * @param value The numerical value to represent.
     */
    public Numeral(double value) {
        this.value = value;
    }

    /**
     * Returns a string representation of the numerical value.
     *
     * @return A string representing the numerical value as an integer.
     */
    @Override
    public String toString() {
        return String.valueOf((int) value);
    }

    /**
     * Evaluates the numerical value and returns it.
     *
     * @return The numerical value.
     */
    @Override
    public double evaluate() {
        return value;
    }
}
