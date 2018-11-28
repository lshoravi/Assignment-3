package org.ioopm.calculator.ast;
import java.util.HashMap;


/**
 * This class represents <i>constants
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Constant extends Atom {
    ublic class Binary extends SymbolicExpression {
    /**
   * Holds the value.
   * @see #value
   */
    private double value;


    /**
   * Creates a new constant that represents the value.
   * @param value The value
   */
    public Constant(double value) {
        super("Constant");
        this.value = value;
    }

           /**
   * Check if contant is constant
   * @return True.
   */
    @Override
    public boolean isConstant() {
        return true;
    }

           /**
   * Get constant value.
   * @return Value of constant.
   * @see #value
   */
    public double getValue() {
        return value;
    }


    /**
   * Evaluates the constant.
   * @param vars Enviroment holding saved variables.
   * @return Constant objekt with value.
   */
    public SymbolicExpression eval(Environment vars) {
        return new Constant(this.value);
    }


        /**
   * Checks if object and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Object other) {
        if(other instanceof Constant) {
            return this.equals((Constant) other);
        }
        return false;
    }

                  /**
   * Checks if a constant and this are equivalent.
   * @return True if equal, false otherwise.
   */
    public boolean equals(Constant other) {
        return this.value == other.value;
    }

            /**
   * Get string representation of expression.
   * @return String representation.
   */
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
