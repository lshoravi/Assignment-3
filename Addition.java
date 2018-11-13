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
}
