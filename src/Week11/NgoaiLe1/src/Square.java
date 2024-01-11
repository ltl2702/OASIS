/**
 * Represents a squaring operation in a mathematical expression.
 */
public class Square extends Expression {
    private Expression expression;

    /**
     * Constructs a Square object that squares a given expression.
     *
     * @param expression The expression to be squared.
     */
    public Square(Expression expression) {
        this.expression = expression;
    }

    /**
     * Returns a string representation of the squaring operation.
     *
     * @return A string representing the squaring operation in the format "(expression) ^ 2".
     */
    @Override
    public String toString() {
        return "(" + expression.toString() + ") ^ 2";
    }

    /**
     * Evaluates the squaring operation and returns the squared result.
     *
     * @return The square of the value obtained by evaluating the enclosed expression.
     */
    @Override
    public double evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
}
