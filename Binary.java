
public class Binary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Binary(String op, SymbolicExpression lhs, SymbolicExpression rhs) {
        super(op, new SymbolicExpression[] {lhs, rhs});
    }

}
