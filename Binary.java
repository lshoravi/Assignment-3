
public class Binary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Binary(String op, SymbolicExpression lhs, SymbolicExpression rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String getName() {
        return this.op;
    }

    public String toString() {
        return (this.lhs.toString() + " " + this.getName() + " " + this.rhs.toString());
     }
}
