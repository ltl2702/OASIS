/**
 * Represents a mathematical expression.
 * Subclasses must provide implementations for evaluate() and toString() methods.
 */
public abstract class Expression {

   /**
    * Evaluates the mathematical expression and returns the result.
    *
    * @return The result of evaluating the expression.
    */
   public abstract double evaluate();

   /**
    * Converts the expression to a string representation.
    *
    * @return A string representation of the expression.
    */
   public abstract String toString();
}
