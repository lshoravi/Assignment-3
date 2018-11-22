package org.ioopm.calculator;

/// File: ParserDriver.java
import java.io.IOException;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;

public class Calculator {

    public static void main(String[] args) {
        CalculatorParser p = new CalculatorParser();
        boolean dontQuit = true;
        Environment vars = new Environment();
        Environment backupVars = new Environment();
        int counter = 0;
        int successCounter = 0;
        int evalCounter = 0;

        System.out.println("Welcome to the parser!");

        while (dontQuit) {
            System.out.print("Please enter an expression: ");
             try {
                 counter += 1;
                 SymbolicExpression result = p.top_level();

                 if (result.isCommand()) {
                     switch (result.toString()) {
                     case ("Clear"):
                         vars.clear();
                         break;
                     case ("Vars"):
                         System.out.println(vars.toString());
                         break;
                     case ("Quit"):
                         System.out.println("Expressions entered:" + counter + "\n" +
                                            "Expressions evaluated: " + successCounter + "\n" +
                                            "Expressions fully evaluated: " + evalCounter + "\n" +
                                            "Goodbye my friend, it was nice passing ways with you.");
                         dontQuit = false;
                     }

                 } else {
                     result = result.eval(vars);
                     System.out.println("result: " + result);

                     successCounter += 1;
                     if (result.isConstant()) {
                         evalCounter += 1;
                     }
                 }

             } catch(SyntaxErrorException e) {
                 System.out.print("Syntax Error: ");
                 System.out.println(e.getMessage());
             } catch(IOException e) {
                 System.err.println("IO Exception!");
                 dontQuit = false;
             } catch(Assignment.IllegalExpressionException e) {
                 System.out.print("Syntax Error: ");
                 System.out.println(e.getMessage());
             }
        }
    }
}
