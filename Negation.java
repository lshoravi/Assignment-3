

public class Negation extends Unary {
    public Negation(SymbolicExpression pram) {
        super("neg", pram);
    }

    @Override
    public String getName() {
        throw new RuntimeException("WHAT IS NEGATION????");
    }
}
