package org.ioopm.calculator.ast;

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
}
