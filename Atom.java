package org.ioopm.calculator.ast;

public class Atom extends SymbolicExpression {
    protected String type;

    public Atom(String type) {
        this.type = type;
    }
}
