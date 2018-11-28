package org.ioopm.calculator.ast;
import java.util.HashMap;


/**
 * This class represents <i>variables
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Variable extends Atom {

      /**
   * Holds the name of this variable.
   * @see #id
   */
    private String id;


         /**
   * Creates a new variable.
   * @param id The name of the variable.
   */
    public Variable(String id) {
        super("Variable");
        this.id = id;
    }

          /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Variable) {
            return this.equals((Variable) other);
        }
        return false;
    }

           /**
   * Evaluates the variable.
   * @param vars Enviroment holding saved variables.
   * @return Value corresponding to variable in vars or a variable objekt if variable is not defined in vars.
   */
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression val = vars.get(this);
        if(val != null) {
            return val;
        }
        return new Variable(this.id);
    }

               /**
   * Checks if variable object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Variable other) {
        return this.id.equals(other.id);
    }

               /**
   * Generates a hashcode for variable..
   * @return Matching hashcode.
   */
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

               /**
   * Get string representation of object.
   * @return String representation.
   */
    @Override
    public String toString() {
        return this.id;
    }
}
