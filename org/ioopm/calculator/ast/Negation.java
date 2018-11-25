package org.ioopm.calculator.ast;
import java.util.HashMap;


/**
 * This class represents the <i>negative expression
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Negation extends Unary {
    public Negation(SymbolicExpression pram) {
        super("neg", pram);
    }

          /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Negation) {
            return this.equals((Negation) other);
        }
        return false;
    }

               /**
   * Checks if a Negation object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Negation other) {
        return this.pram.equals(other.pram);
    }

                   /**
   * Evaluates the negation expression.
   * @param vars Enviroment holding saved variables.
   * @return Result as a negative constant if expression is fully evaluated, otherwi
   * se negation expression with pram evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(-arg.getValue());
        }
        else {
            return new Negation(arg);
        }
    }

           /**
   * Get string representation of expression.
   * @return String representation: "-pram"
   */
    @Override
    public String toString() {
        return "-" + this.pram.toString();
    }

           /**
   * Get operation name.
   * @return Name of operation, "-".
   */
    @Override
    public String getName() {
        return "-";
    }
}
