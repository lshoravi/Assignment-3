package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents <i>binary expressions
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Binary extends SymbolicExpression {
    /**
   * Holds the operation of this binary expression.
   * @see #op
   */
    protected String op = null;

    /**
   * Holds the lefthand side of the binary expression.
   * @see #lhs
   */
    protected SymbolicExpression lhs = null;

    /**
   * Holds the right hand side of the binary expression.
   * @see #rhs
   */
    protected SymbolicExpression rhs = null;


    /**
   * Creates a new binary expression that represents the binary expression lhs op rhs.
   * @param op The operation.
   * @param lhs The left hand side of the expression.
   * @param rhs The righthand side of the expression.
   * @param priority The priority of the operation above.
   */
    public Binary(String op, SymbolicExpression lhs, SymbolicExpression rhs, int priority) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
        this.setPriority(priority);
    }


    /**
   * Evaluates the binary expression.
   * @param vars Enviroment holding saved variables.
   * @exception RuntimeException thrown if called on binary expression without overridden eval.
   */
    public SymbolicExpression eval(Environment vars) {
        throw new RuntimeException("eval not implemented for operation");
    }



      /**
   * Get operation name.
   * @return Name of operation, op.
   */
    @Override
    public String getName() {
        return this.op;
    }

      /**
   * Get string representation of expression.
   * @return String representation.
   */
    @Override
    public String toString() {
        return (this.subtreeToString(lhs) + " " + this.getName() + " " + this.subtreeToString(rhs));
     }
}
