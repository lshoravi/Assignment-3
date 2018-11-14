package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Sin extends Unary {
    public Sin(SymbolicExpression pram) {
        super("sin", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Sin) {
            return this.equals((Sin) other);
        }
        return false;
    }

    public boolean equals(Sin other) {
        return this.pram.equals(other.pram);
    }

    public SymbolicExpression eval(HashMap<Variable,SymbolicExpression> vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        }
        else {
            return new Sin(arg);
        }
    }
}
