package org.ioopm.calculator.ast;

public class Log extends Unary {
    public Log(SymbolicExpression pram) {
        super("Log", pram);
    }
}
