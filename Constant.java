

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

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
