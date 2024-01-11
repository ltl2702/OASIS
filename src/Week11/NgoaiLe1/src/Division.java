/**
 * Represents a division operation in a mathematical expression.
 */
public class Division extends BinaryExpression {

    /**
     * Constructs a Division object with two sub-expressions.
     *
     * @param left  The left sub-expression (dividend).
     * @param right The right sub-expression (divisor).
     */
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Returns a string representation of the division operation.
     *
     * @return A string representing the division operation in the format "(left / right)".
     */
    @Override
    public String toString() {
        return '(' + left.toString() + " / " + right.toString() + ')';
    }

    /**
     * Evaluates the division operation and returns the result.
     *
     * @return The result of dividing the left sub-expression by the right sub-expression.
     * @throws ArithmeticException if the divisor is zero.
     */
    @Override
    public double evaluate() {
        double divisor = right.evaluate();
        if (divisor == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        }
        return left.evaluate() / divisor;
    }
}
