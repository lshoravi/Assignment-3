package org.ioopm.calculator.ast;

/** The clear class is a singleton that represents a
 * command that removes any variable bindings in the environment.
 * @author Nils & Astrid
 * @version 1.0
 */
public class Clear extends Command {
    private static final Clear theInstance = new Clear();

    private Clear() {}

    /** Returns the singleton. */
    public static Clear instance() {
        return theInstance;
    }

    @Override
    public String toString() {
        return "Clear";
    }
}
