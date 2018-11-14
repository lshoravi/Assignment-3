package org.ioopm.calculator.ast;

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

    public SymbolicExpression eval() {
        SymbolicExpression left = this.lhs.eval();
        SymbolicExpression right = this.rhs.eval();
        if(left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() + right.getValue());
        }
        else {
            return new Addition(left, right);
        }
    }
}
