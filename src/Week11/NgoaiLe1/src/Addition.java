/**
 * Represents an addition operation in a mathematical expression.
 */
public class Addition extends BinaryExpression {

    /**
     * Constructs an Addition object with two sub-expressions.
     *
     * @param left  The left sub-expression.
     * @param right The right sub-expression.
     */
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Returns a string representation of the addition operation.
     *
     * @return A string representing the addition operation.
     */
    @Override
    public String toString() {
        return '(' + left.toString() + " + " + right.toString() + ')';
    }

    /**
     * Evaluates the addition operation and returns the result.
     *
     * @return The result of adding the left and right sub-expression values.
     */
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
