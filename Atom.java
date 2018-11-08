

public class Atom extends SymbolicExpression {
    public Atom(String type, SymbolicExpression value) {
        super(type, new SymbolicExpression[] {value});
    }
}
