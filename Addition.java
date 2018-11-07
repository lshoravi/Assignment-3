package org.ioopm.calculator.ast;

public class Addition extends SymbolicExpression {
    public Addition(SymbolicExpression exp1, SymbolicExpression exp2) {
        super("Addition", exp1, exp2);
    }
}
