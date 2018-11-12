

public class Exp extends Unary {
    public Exp(SymbolicExpression pram) {
        super("exp", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Exp) {
            return this.equals((Exp) other);
        }
        return false;
    }

    public boolean equals(Exp other) {
        return this.pram.equals(other.pram);
    }
}
