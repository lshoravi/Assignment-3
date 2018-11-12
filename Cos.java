

public class Cos extends Unary {
    public Cos(SymbolicExpression pram) {
        super("cos", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Cos) {
            return this.equals((Cos) other);
        }
        return false;
    }

    public boolean equals(Cos other) {
        return this.pram.equals(other.pram);
    }
}
