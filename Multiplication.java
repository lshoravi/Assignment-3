package org.ioopm.calculator.ast.Multiplication;

public class Multiplication extends Binary {
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Multiplication", lhs, rhs);
    }
}
