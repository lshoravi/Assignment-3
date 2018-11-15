package org.ioopm.calculator.ast;
import java.util.HashMap;


public class Atom extends SymbolicExpression {
    protected String type;

    public Atom(String type) {
        this.type = type;
    }

    public SymbolicExpression eval(HashMap<String, SymbolicExpression> vars) {
        throw new RuntimeException("eval not implemented for type");
    }
}
