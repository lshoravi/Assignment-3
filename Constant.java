

public class Constant extends Atom {
    private double value;

    public Constant(double value) {
        super("Constant");
        this.value = value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    public double getValue() {
        return value;
    }

    public boolean equals(Object other) {
        if(other instanceof Constant) {
            return this.equals((Constant) other);
        }
        return false;
    }

    public boolean equals(Constant other) {
        return this.value == other.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
