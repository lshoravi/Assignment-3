package org.ioopm.calculator.parser;

/// File: ParserDriver.java
import java.io.IOException;
import org.ioopm.calculator.ast.*;

public class ParserDriver {
    public static void main(String[] args) {
        CalculatorParser p = new CalculatorParser();

        System.out.println("Welcome to the parser!");
        System.out.print("Please enter an expression: ");

        try {
            SymbolicExpression result = p.top_level();
            System.out.println("result: " + result);
        } catch(SyntaxErrorException e) {
            System.out.print("Syntax Error: ");
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.err.println("IO Exception!");
        }
    }
}
