package org.ioopm.calculator.ast;

public class Subtraction extends SymbolicExpression {
    public Subtraction(SymbolicExpression term1, SymbolicExpression term2) {
        super("Subtraction", term1, term2);
    }
}
