package org.ioopm.calculator.ast;
import java.util.HashMap;

public abstract class SymbolicExpression {
    private int priority = 10;

    public boolean isConstant() {
        return false;
    }

    public boolean isCommand() {
        return false;
    }

    public double getValue() {
        throw new RuntimeException("getValue called on non-Constant expression");
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean equals(Object other) {
        throw new RuntimeException("equals not defined for expression");
    }

    public abstract SymbolicExpression eval(Environment vars);

    public String subtreeToString(SymbolicExpression e) {
        if (e.getPriority() < this.getPriority()) {
            return "(" + e.toString() + ")";
        } else {
            return  e.toString();
        }
    }
}
