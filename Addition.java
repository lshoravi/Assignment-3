
public class Addition extends Binary {

    public Addition(SymbolicExpression lhs, SymbolicExpression rhs) {
        super("Addition", lhs, rhs);
    }

    @Override
    public String getName() {
        return "+";
    }
}
