

public class Constant extends Atom {
    private double value;

    public Constant(double value) {
        super("Constant", null);
        this.value = value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
}
