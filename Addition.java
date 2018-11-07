package org.ioopm.calculator.ast.Addition;

public class Addition extends Binary {
    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Addition", lhs, rhs);
    }
}
