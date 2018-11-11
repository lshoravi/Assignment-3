

public abstract class SymbolicExpression {
    private int priority;

    public boolean isConstant() {
        return false;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public int getPriority() {
        return this.priority;
    }
}
