

public class Command extends SymbolicExpression {
    protected String op = null;

    public Command(String op) {
        this.op = op;
    }

    public SymbolicExpression eval() {
        throw new RuntimeException("Cannot evaluate Command expression");
    }
}
