package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents the binary expression <i>multiplication
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Multiplication extends Binary {

         /**
   * Creates a new multiplication that represents the expression lhs * rhs.
   * @param lhs The left hand side of the expression.
   * @param rhs The righthand side of the expression.
   */
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("*", lhs, rhs, 5);
    }

           /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Multiplication) {
            return this.equals((Multiplication) other);
        }
        return false;
    }

           /**
   * Checks if an multiplication and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Multiplication other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }

              /**
   * Evaluates the multiplication.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant if both sides of the expression are fully evaluated, otherwi
   * se multiplication with terms evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        SymbolicExpression right = this.rhs.eval(vars);
        if(left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() * right.getValue());
        }
        else {
            return new Multiplication(left, right);
        }
    }
}
