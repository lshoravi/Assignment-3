package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents the binary expression <i>assignment
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Assignment extends Binary {
    private Variable var;

        /**
   * Creates a new assignment that represents the expression lhs = rhs.
   * @param lhs The left hand side of the expression.
   * @param rhs The righthand side of the expression.
   */
    public Assignment(SymbolicExpression lhs, Variable rhs) {
        super("=", lhs, rhs, 1);
        var = rhs;
    }

    public static class IllegalExpressionException extends RuntimeException {
        public IllegalExpressionException(String msg) {
            super(msg);
        }
    }

           /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Assignment) {
            return this.equals((Assignment) other);
        }
        return false;
    }

             /**
   * Checks if an assignment and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Assignment other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }

           /**
   * Evaluates the assignment.
   * @param vars Enviroment holding saved variables.
   * @return Result as a constant if both sides of the expression are fully evaluated, otherwi
   * se assignment with terms evaluated as far as possible.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        Variable right = this.var;
        vars.put(right, left);
        return left;
    }
}
