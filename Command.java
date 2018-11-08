

public class Command extends SymbolicExpression {
    private String op = null;

    public Command(String op) {
        super(op, null);
        this.op = op;
    }

}
