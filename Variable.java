package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Variable extends Atom {
    private String id;

    public Variable(String id) {
        super("Variable");
        this.id = id;
    }

    public boolean equals(Object other) {
        if(other instanceof Variable) {
            return this.equals((Variable) other);
        }
        return false;
    }

    public SymbolicExpression eval(HashMap<Variable,SymbolicExpression> vars) {
        SymbolicExpression val = vars.get(this.id);
        if(val != null) {
            return val;
        }
        return new Variable(this.id);
    }

    public boolean equals(Variable other) {
        return this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return this.id;
    }
}
