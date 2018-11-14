package org.ioopm.calculator.ast;
import java.util.HashMap;

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

    public SymbolicExpression eval(HashMap<Variable,SymbolicExpression> vars) {
        SymbolicExpression left = this.lhs.eval(vars);
        SymbolicExpression right = this.rhs.eval(vars);
        if(left.isConstant() && right.isConstant()) {
            return new Constant(left.getValue() - right.getValue());
        }
        else {
            return new Subtraction(left, right);
        }
    }
}
