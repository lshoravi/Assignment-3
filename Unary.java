package org.ioopm.calculator.ast;

public class Unary extends SymbolicExpression {
    protected String op = null;
    protected SymbolicExpression pram = null;

    public Unary(String op, SymbolicExpression pram) {
       this.op = op;
       this.pram = pram;
    }

    public SymbolicExpression eval() {
        throw new RuntimeException("eval not implemented for operation");
    }

    @Override
    public String getName() {
        return this.op;
    }

    public String toString() {
        return this.getName() + " " + this.subtreeToString(pram);
     }
}
