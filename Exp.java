package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Exp extends Unary {
    public Exp(SymbolicExpression pram) {
        super("exp", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Exp) {
            return this.equals((Exp) other);
        }
        return false;
    }

    public boolean equals(Exp other) {
        return this.pram.equals(other.pram);
    }

    public SymbolicExpression eval(HashMap<Variable,SymbolicExpression> vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.exp(arg.getValue()));
        }
        else {
            return new Exp(arg);
        }
    }
}
