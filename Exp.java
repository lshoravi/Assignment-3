

public class Exp extends Unary {
    public Exp(SymbolicExpression pram) {
        super("Exp", pram);
    }

    @Override
    public String getName() {
        return "exp";
    }
}
