package org.ioopm.calculator.ast;

public class Negation extends Unary {
    public Negation(SymbolicExpression pram) {
        super("Negation", pram);
    }
}
