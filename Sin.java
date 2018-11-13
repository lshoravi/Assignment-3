package org.ioopm.calculator.ast;

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

    public SymbolicExpression eval() {
        SymbolicExpression arg = this.pram.eval();

        if(arg.isConstant()) {
            return new Constant(Math.sin(arg.getValue()));
        }
        else {
            return new Sin(arg);
        }
    }
}
