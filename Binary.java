
public class Binary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Binary(String op, SymbolicExpression lhs, SymbolicExpression rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;

    }

    public String toString() {
        String expression = (op + "(" + lhs.toString() + ", " + rhs.toString());
        return expression;
    }
}
