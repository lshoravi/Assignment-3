

public class Unary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression pram = null;

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
