

public class Log extends Unary {
    public Log(SymbolicExpression pram) {
        super("Log", pram);
    }

    @Override
    public String getName() {
        return "log";
    }
}
