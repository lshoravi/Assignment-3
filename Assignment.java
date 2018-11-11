
public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("=", lhs, rhs, 1);
    }
}
