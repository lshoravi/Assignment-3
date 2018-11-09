

public class Sin extends Unary {
    public Sin(SymbolicExpression pram) {
        super("Sin", pram);
    }

    @Override
    public String getName() {
        return "sin";
    }
}
