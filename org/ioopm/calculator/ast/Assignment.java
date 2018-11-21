package org.ioopm.calculator.ast;
import java.util.HashMap;


public class Assignment extends Binary {
    private Variable var;

    public Assignment(SymbolicExpression lhs, Variable rhs) {
        super("=", lhs, rhs, 1);
        var = rhs;
    }

    public static class IllegalExpressionException extends RuntimeException {
        public IllegalExpressionException(String msg) {
            super(msg);
        }
    }

    public boolean equals(Object other) {
        if(other instanceof Assignment) {
            return this.equals((Assignment) other);
        }
        return false;
    }

    public boolean equals(Assignment other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        Variable right = this.var;
        vars.put(right, left);
        return left;
    }
}
