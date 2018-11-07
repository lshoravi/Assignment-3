package org.ioopm.calculator.ast.Subtraction;

public class Subtraction extends Binary {
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Subtraction", lhs, rhs);
    }
}
