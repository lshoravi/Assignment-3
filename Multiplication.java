

public class Multiplication extends Binary {
    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Multiplication", lhs, rhs);
    }

    @Override
    public String getName() {
        return "*";
    }
}
