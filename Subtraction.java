package org.ioopm.calculator.ast;

public class Subtraction extends Binary {
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("-", lhs, rhs, 4);
    }

    public boolean equals(Object other) {
        if(other instanceof Subtraction) {
            return this.equals((Subtraction) other);
        }
        return false;
    }

    public boolean equals(Subtraction other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }
}
