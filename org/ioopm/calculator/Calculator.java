package org.ioopm.calculator;

/// File: ParserDriver.java
import java.io.IOException;
import org.ioopm.calculator.ast.*;
import org.ioopm.calculator.parser.*;

public class Calculator {
    public static void main(String[] args) {
        CalculatorParser p = new CalculatorParser();
        boolean dontQuit = true;

        System.out.println("Welcome to the parser!");

        while (dontQuit) {
            System.out.print("Please enter an expression: ");
             try {

                 SymbolicExpression result = p.top_level();
                 System.out.println("result: " + result);

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
