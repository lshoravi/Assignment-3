package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents the <i>Log expression
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Log extends Unary {

         /**
   * Creates a new Log expression that represents the unary expression Log(pram).
   * @param pram The value of the expression.
   */
    public Log(SymbolicExpression pram) {
        super("log", pram);
    }

                /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Log) {
            return this.equals((Log) other);
        }
        return false;
    }

               /**
   * Checks if a Log object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Log other) {
        return this.pram.equals(other.pram);
    }

                   /**
   * Evaluates the Log expression.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant if expression is fully evaluated, otherwi
   * se Log expression with pram evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        }
        else {
            return new Log(arg);
        }
    }
}
