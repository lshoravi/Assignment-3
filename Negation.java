

public class Negation extends Unary {
    public Negation(SymbolicExpression pram) {
        super("neg", pram);
    }

    public boolean equals(Object other) {
        if(other instanceof Negation) {
            return this.equals((Negation) other);
        }
        return false;
    }

    public boolean equals(Negation other) {
        return this.pram.equals(other.pram);
    }

    public SymbolicExpression eval() {
        SymbolicExpression arg = this.pram.eval();

        if(arg.isConstant()) {
            return new Constant(-arg.getValue());
        }
        else {
            return new Negation(arg);
        }
    }

    @Override
    public String getName() {
        return "-";
    }
}
