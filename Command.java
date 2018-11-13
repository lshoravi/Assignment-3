package org.ioopm.calculator.ast;

public class Command extends SymbolicExpression {
    @Override
    public boolean isCommand() {
        return true;
    }
}
