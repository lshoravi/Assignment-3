private class NamedConstant extends Constant {
    private String name;

    public NamedConstant(double value, String name) {
        super(value);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }


}
