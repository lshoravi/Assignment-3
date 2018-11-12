

public class Multiplication extends Binary {
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("*", lhs, rhs, 5);
    }

    public boolean equals(Object other) {
        if(other instanceof Multiplication) {
            return this.equals((Multiplication) other);
        }
        return false;
    }

    public boolean equals(Multiplication other) {
        return this.lhs.equals(other.lhs) && this.rhs.equals(other.rhs);
    }
}
