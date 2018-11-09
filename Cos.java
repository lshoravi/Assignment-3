

public class Cos extends Unary {
    public Cos(SymbolicExpression pram) {
        super("Cos", pram);
    }

    @Override
    public String getName() {
        return "cos";
    }
}
