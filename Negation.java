

public class Negation extends Unary {
    public Negation(SymbolicExpression pram) {
        super("neg", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Negation) {
            return this.equals((Negation) other);
        }
        return false;
    }

    public boolean equals(Negation other) {
        return this.pram.equals(other.pram);
    }

    @Override
    public String getName() {
        throw new RuntimeException("WHAT IS NEGATION????");
    }
}
