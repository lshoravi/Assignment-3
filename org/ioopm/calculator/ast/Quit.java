package org.ioopm.calculator.ast;

public class Quit extends Command {
    private static final Quit theInstance = new Quit();
    private static boolean created = false;

    private Quit() {
        assert created != true;
        created = true;
    }

    public static Quit instance() {
        return theInstance;
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
