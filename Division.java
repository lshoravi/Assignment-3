package org.ioopm.calculator.ast.Division;

public class Division extends Binary {
    public Division(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Division", lhs, rhs);
    }
}
