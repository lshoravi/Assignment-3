package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Binary extends SymbolicExpression {
    protected String op = null;
    protected SymbolicExpression lhs = null;
    protected SymbolicExpression rhs = null;

    public Binary(String op, SymbolicExpression lhs, SymbolicExpression rhs, int priority) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
        this.setPriority(priority);
    }

    public SymbolicExpression eval(HashMap<String, SymbolicExpression> vars) {
        throw new RuntimeException("eval not implemented for operation");
    }

    @Override
    public String getName() {
        return this.op;
    }

    public String toString() {
        return (this.subtreeToString(lhs) + " " + this.getName() + " " + this.subtreeToString(rhs));
     }
}
