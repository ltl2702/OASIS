/**
 * Represents a subtraction operation in a mathematical expression.
 */
public class Subtraction extends BinaryExpression {

    /**
     * Constructs a Subtraction object with two sub-expressions.
     *
     * @param left  The left sub-expression (minuend).
     * @param right The right sub-expression (subtrahend).
     */
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Returns a string representation of the subtraction operation.
     *
     * @return A string representing the subtraction operation in the format "(left - right)".
     */
    @Override
    public String toString() {
        return '(' + left.toString() + " - " + right.toString() + ')';
    }

    /**
     * Evaluates the subtraction operation and returns the result.
     *
     * @return The result of subtracting the right sub-expression from the left sub-expression.
     */
    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
