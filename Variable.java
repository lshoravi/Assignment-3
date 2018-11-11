

public class Variable extends Atom {
    private String id;

    public Variable(String id) {
        super("Variable");
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id;
    }

}
