

public class Subtraction extends Binary {
    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Subtraction", lhs, rhs);
    }

    @Override
    public String getName() {
        return "-";
    }
}
