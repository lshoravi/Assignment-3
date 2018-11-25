package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents the binary expression <i>division
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Division extends Binary {


       /**
   * Creates a new division that represents the expression lhs / rhs.
   * @param lhs The left hand side of the expression.
   * @param rhs The righthand side of the expression.
   */
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("/", lhs, rhs, 5);
    }

           /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Division) {
            return this.equals((Division) other);
        }
        return false;
    }

               /**
   * Checks if an division and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Division other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }

              /**
   * Evaluates the division.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant if both sides of the expression are fully evaluated, otherwi
   * se division with terms evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        SymbolicExpression right = this.rhs.eval(vars);
        if(left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() / right.getValue());
        }
        else {
            return new Division(left, right);
        }
    }
}
