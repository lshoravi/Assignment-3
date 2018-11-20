package org.ioopm.calculator.ast;
import java.util.HashMap;


public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("=", lhs, rhs, 1);
    }

    public class IllegalExpressionException extends RuntimeException {
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

    public SymbolicExpression eval(HashMap<String,SymbolicExpression> vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        SymbolicExpression right = this.rhs;

        return new Assignment(left, right);
    }
}
