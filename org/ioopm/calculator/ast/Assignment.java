package org.ioopm.calculator.ast;

public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("=", lhs, rhs, 1);
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

    public SymbolicExpression eval() {
        SymbolicExpression left = this.lhs.eval();
        SymbolicExpression right = this.rhs;

        return new Assignment(left, right);
    }
}