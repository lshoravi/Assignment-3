package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("+", lhs, rhs, 4);
    }

    public boolean equals(Object other) {
        if(other instanceof Addition) {
            return this.equals((Addition) other);
        }
        return false;
    }

    public boolean equals(Addition other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }

    public SymbolicExpression eval(HashMap<Variable,SymbolicExpression> vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        SymbolicExpression right = this.rhs.eval(vars);
        if(left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() + right.getValue());
        }
        else {
            return new Addition(left, right);
        }
    }
}
