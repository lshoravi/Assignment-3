

public class Variable extends Atom {
    private String id;
    public Variable(String id, SymbolicExpression value) {
        super("Variable", value);
        this.id = id;
    }
}
