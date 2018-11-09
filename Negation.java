

public class Negation extends Unary {
    public Negation(SymbolicExpression pram) {
        super("Negation", pram);
    }

    @Override
    public String getName() {
        throw new RuntimeException("WHAT IS NEGATION????");
    }
}
