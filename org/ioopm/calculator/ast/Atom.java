package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents <i>atomic expressions
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class Atom extends SymbolicExpression {
    /**
   * Holds the type of this atomic expression, i.e. variable or constant.
   */
    protected String type;

    /**
   * Creates a new atomic  expression.
   * @param type The type of the atomic expression.
   */
    public Atom(String type) {
        this.type = type;
    }

      /**
   * Evaluates the atomic expression.
   * @param vars Enviroment holding saved variables.
   * @exception RuntimeException when called on type that can't be evaluated.
   */
    public SymbolicExpression eval(Environment vars) {
        throw new RuntimeException("eval not implemented for type");
    }
}
