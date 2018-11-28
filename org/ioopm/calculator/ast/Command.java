package org.ioopm.calculator.ast;
import java.util.HashMap;

/**
 * This class represents <i> commands
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */

public class Command extends SymbolicExpression {

        /**
   * Check if command is command.
   * @return True.
   */
    @Override
    public boolean isCommand() {
        return true;
    }

         /**
   * Evaluates the command expression.
   * @param vars Enviroment holding saved variables.
   * @exception RuntimeException thrown if called.
   */
    public SymbolicExpression eval(Environment vars) {
        throw new RuntimeException("Cannot evaluate Command expression");
    }
}
