package org.ioopm.calculator.ast;

public class Command extends SymbolicExpression {
    @Override
    public boolean isCommand() {
        return true;
    }

    public SymbolicExpression eval() {
        throw new RuntimeException("Cannot evaluate Command expression");
    }
