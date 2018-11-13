

public class Atom extends SymbolicExpression {
    protected String type;

    public Atom(String type) {
        this.type = type;
    }

    public SymbolicExpression eval() {
        throw new RuntimeException("eval not implemented for type");
    }
}
