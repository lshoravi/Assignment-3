package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents the <i>Cos expression
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Cos extends Unary {

           /**
   * Creates a new Cos expression that represents the unary expression Cos(pram).
   * @param pram The value of the expression.
   */
    public Cos(SymbolicExpression pram) {
        super("cos", pram);
    }

              /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Cos) {
            return this.equals((Cos) other);
        }
        return false;
    }

               /**
   * Checks if a Cos object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Cos other) {
        return this.pram.equals(other.pram);
    }


               /**
   * Evaluates the Cos expression.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant if expression is fully evaluated, otherwi
   * se Cos expression with pram evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.cos(arg.getValue()));
        }
        else {
            return new Cos(arg);
        }
    }
}
