

public abstract class SymbolicExpression {
    private int priority = 10;

    public boolean isConstant() {
        return false;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression with no operator");
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String subtreeToString(SymbolicExpression e) {
        if (e.getPriority() < this.getPriority()) {
            return "(" + e.toString() + ")";
        } else {
            return  e.toString();
        }
    }
}
