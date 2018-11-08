

public abstract class SymbolicExpression {
    private String name;
    private SymbolicExpression[] subExpressions;

    public SymbolicExpression(String name, SymbolicExpression subExpressions[]) {
        this.name = name;
        this.subExpressions = subExpressions;
    }
}
