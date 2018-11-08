

public class Unary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression pram = null;

    public Unary(String op, SymbolicExpression pram) {
        super(op, new SymbolicExpression[] {pram});
    }

}
