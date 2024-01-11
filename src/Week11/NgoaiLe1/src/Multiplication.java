/**
 * Represents a multiplication operation in a mathematical expression.
 */
public class Multiplication extends BinaryExpression {

    /**
     * Constructs a Multiplication object with two sub-expressions.
     *
     * @param left  The left sub-expression.
     * @param right The right sub-expression.
     */
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * Returns a string representation of the multiplication operation.
     *
     * @return A string representing the multiplication operation in the format "(left x right)".
     */
    @Override
    public String toString() {
        return '(' + left.toString() + " * " + right.toString() + ')';
    }

    /**
     * Evaluates the multiplication operation and returns the result.
     *
     * @return The result of multiplying the left and right sub-expression values.
     */
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
