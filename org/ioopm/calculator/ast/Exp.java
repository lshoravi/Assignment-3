package org.ioopm.calculator.ast;

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

    public SymbolicExpression eval() {
        SymbolicExpression arg = this.pram.eval();

        if(arg.isConstant()) {
            return new Constant(Math.exp(arg.getValue()));
        }
        else {
            return new Exp(arg);
        }
    }
}
