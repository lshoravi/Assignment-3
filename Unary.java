

public class Unary extends SymbolicExpression {
    protected String op = null;
    protected SymbolicExpression pram = null;

    public Unary(String op, SymbolicExpression pram) {
       this.op = op;
       this.pram = pram;
    }

    @Override
    public String getName() {
        return this.op;
    }

    public String toString() {
        return this.getName() + " " + this.subtreeToString(pram);
     }
}
