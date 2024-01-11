/**
 * Represents a binary mathematical expression.
 * Subclasses must provide implementations for toString() and evaluate() methods.
 */
public abstract class BinaryExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public abstract String toString();

    public abstract double evaluate();
}
