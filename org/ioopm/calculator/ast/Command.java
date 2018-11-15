package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Command extends SymbolicExpression {
    @Override
    public boolean isCommand() {
        return true;
    }

    public SymbolicExpression eval(HashMap<String, SymbolicExpression> vars) {
        throw new RuntimeException("Cannot evaluate Command expression");
    }
}
