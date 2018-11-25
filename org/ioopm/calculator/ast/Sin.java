package org.ioopm.calculator.ast;
import java.util.HashMap;


/**
 * This class represents the <i>Sin expression
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Sin extends Unary {

         /**
   * Creates a new Sin expression that represents the unary expression Sin(pram).
   * @param pram The value of the expression.
   */
    public Sin(SymbolicExpression pram) {
        super("sin", pram);
    }

            /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Sin) {
            return this.equals((Sin) other);
        }
        return false;
    }

             /**
   * Checks if a Sin object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Sin other) {
        return this.pram.equals(other.pram);
    }

               /**
   * Evaluates the Sin expression.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant if expression is fully evaluated, otherwi
   * se Sin expression with pram evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        }
        else {
            return new Sin(arg);
        }
    }
}
