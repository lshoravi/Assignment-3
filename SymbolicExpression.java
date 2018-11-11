

public abstract class SymbolicExpression {
    public Int priority;
    // private String name;
    // private SymbolicExpression[] subExpressions;

    // public SymbolicExpression(String name, SymbolicExpression subExpressions[]) {
    //     this.name = name;
    //     this.subExpressions = subExpressions;
    // }

    public boolean isConstant() {
        return false;
    }

    public String getName() {
        throw new RuntimeException("getName() called on expression of type " + this.name + " with no operator");
    }

    public Int getPriority() {
        return this.priority;
    }
}
