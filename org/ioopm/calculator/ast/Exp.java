package org.ioopm.calculator.ast;
import java.util.HashMap;

    /**
 * This class represents the <i>natural logarithm expression
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Exp extends Unary {


         /**
   * Creates a new exponential expression that represents the unary expression Exp(pram) or e ^ pram.
   * @param pram The value of the expression.
   */
    public Exp(SymbolicExpression pram) {
        super("exp", pram);
    }

      /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Exp) {
            return this.equals((Exp) other);
        }
        return false;
    }

               /**
   * Checks if a Exp object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Exp other) {
        return this.pram.equals(other.pram);
    }


               /**
   * Evaluates the exponential expression.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant, e ^ pram, if expression is fully evaluated, otherwi
   * se Exp expression with pram evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.exp(arg.getValue()));
        }
        else {
            return new Exp(arg);
        }
    }
}
