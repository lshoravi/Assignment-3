

public class Unary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression pram = null;

    public Unary(String op, SymbolicExpression pram) {
        this.op = op;
        this.pram = pram;
    }

}
