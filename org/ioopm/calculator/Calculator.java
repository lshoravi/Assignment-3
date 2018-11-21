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

        System.out.println("Welcome to the parser!");

        while (dontQuit) {
            System.out.print("Please enter an expression: ");
             try {

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
                         dontQuit = false;
                     }

                 } else {
                     System.out.println("result: " + result.eval(vars));
                 }

             } catch(SyntaxErrorException e) {
                 System.out.print("Syntax Error: ");
                 System.out.println(e.getMessage());
             } catch(IOException e) {
                 System.err.println("IO Exception!");
             } catch(Assignment.IllegalExpressionException e) {
                 System.out.print("Syntax Error: ");
                 System.out.println(e.getMessage());
             }
        }
    }
}
