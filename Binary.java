
public class Binary extends SymbolicExpression {
    private String op = null;
    private SymbolicExpression lhs = null;
    private SymbolicExpression rhs = null;

    public Binary(String op, SymbolicExpression lhs, SymbolicExpression rhs, int priority) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
        this.setPriority(priority);
    }

    @Override
    public String getName() {
        return this.op;
    }

    public String toString() {
        return (this.subtreeToString(lhs) + " " + this.getName() + " " + this.subtreeToString(rhs));
     }
}
