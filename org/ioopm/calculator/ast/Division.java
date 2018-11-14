package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Division extends Binary {
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("/", lhs, rhs, 5);
    }

    public boolean equals(Object other) {
        if(other instanceof Division) {
            return this.equals((Division) other);
        }
        return false;
    }

    public boolean equals(Division other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }

    public SymbolicExpression eval(HashMap<Variable,SymbolicExpression> vars) {
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
