package org.ioopm.calculator.ast;
import java.util.HashMap;

public class Log extends Unary {
    public Log(SymbolicExpression pram) {
        super("log", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Log) {
            return this.equals((Log) other);
        }
        return false;
    }

    public boolean equals(Log other) {
        return this.pram.equals(other.pram);
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression arg = this.pram.eval(vars);

        if(arg.isConstant()) {
            return new Constant(Math.log(arg.getValue()));
        }
        else {
            return new Log(arg);
        }
    }
}
