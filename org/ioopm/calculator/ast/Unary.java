package org.ioopm.calculator.ast;
import java.util.HashMap;


/**
 * This class represents the <i>unary expressions
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Unary extends SymbolicExpression {
      /**
   * Holds the operation of this unary expression.
   * @see #op
   */
    protected String op = null;

     /**
   * Holds the value of the unary expression.
   * @see #pram
   */
    protected SymbolicExpression pram = null;

      /**
   * Creates a new unary expression that represents the unary expression op(pram).
   * @param op The operation.
   * @param pram The value of the expression.
   */
    public Unary(String op, SymbolicExpression pram) {
       this.op = op;
       this.pram = pram;
    }

       /**
   * Evaluates the unary expression.
   * @param vars Enviroment holding saved variables.
   * @exception RuntimeException thrown if called on unary expression without overridden eval.
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
        return this.getName() + " " + this.subtreeToString(pram);
     }
}
