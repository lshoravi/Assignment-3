
public class Assignment extends Binary {
    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Assignment", lhs, rhs);
    }

    @Override
    public String getName() {
        return "=";
    }
}
