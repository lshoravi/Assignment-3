package org.ioopm.calculator.ast;

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
}
