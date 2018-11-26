

package org.ioopm.calculator.parser;


import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import org.ioopm.calculator.ast.*;

/**
 * This class represents <i>the parsing function of the calculator
 * </i>.
 *
 * @author Astrid Nord Olsson, Nils Hedberg
 * @version 1.0
 */
public class CalculatorParser {
    /**
     * Holds the tokenizer that reads the input of the parser
     * @see #st
     */
    private final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    /**
     * Holds a list of accepted function operators in the calculator
     * @see #unaryOperations
     */
    private final List<String> unaryOperations = Arrays.asList("sin", "cos", "log", "exp");

    /**
     * Holds a list of the accepted commands to the calculator
     * @see #commands
     */
    private final List<String> commands = Arrays.asList("Vars", "Quit", "Clear");

    /**
     * Creates a new parser object
     */
    public CalculatorParser () {
        this.st.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :)
        this.st.ordinaryChar('/');
        this.st.eolIsSignificant(true); /// parse end-of-line as ordinary token
    }

    /**
     * Initiates the parsing of an input expression
     * @exception IOException thrown if there was an error in the tokenizer
     * @exception SyntaxErrorException thrown if there was no EOL(end of line) symbol
     */
    public SymbolicExpression top_level() throws IOException {
        SymbolicExpression result =statement();
        if  (st.nextToken() == StreamTokenizer.TT_EOL) {
            return result;
        } else {
            throw new SyntaxErrorException("Expected EOL after statement, got " + st.ttype);
        }
    }

    /**
     * Parses an entire input expression
     * @exception IOException thrown if there was an error in the tokenizer
     */
    public SymbolicExpression statement() throws IOException {
        st.nextToken();
        if (st.ttype == StreamTokenizer.TT_WORD) {
            if (commands.contains(st.sval))  {
                    return command();
            }
        }
        st.pushBack();
        return assignment();
    }

    /**
     * Matches an input expression with a valid command
     * @exception IOException thrown if there was an error in the tokenizer
     * @exception SyntaxErrorException thrown if the parsed expression could not be matched with a valid command
     */
    public SymbolicExpression command() throws IOException {
        if (st.ttype == StreamTokenizer.TT_WORD) {
            if (st.sval.equals( "Vars")) {
                return Vars.instance();
            }
            else if (st.sval.equals("Quit")) {
                return Quit.instance();
            }
            else if (st.sval.equals("Clear")) {
                return Clear.instance();
            }
        }
        throw new SyntaxErrorException("Expected \"Vars\", \"Clear\" or \"Quit\" as command, got " + st.ttype + st.sval);
    }

    /**
     * Tries to parse an expression and make an assignment to a variable
     * @exception IOException thrown if there was an error in the tokenizer
     */
    public SymbolicExpression assignment() throws IOException {
        SymbolicExpression result = lhs();
        while (st.nextToken() == '=') {
            Variable id = rhs();
            result = new Assignment(result, id);
        }
        st.pushBack();
        return result;
    }

    /**
     * Helper function for assignment, returns the left hand side of the equality
     * @exception IOException thrown if there was an error in the tokenizer
     */
    public SymbolicExpression lhs() throws IOException {
        return expression();
    }

    /*
     * Helper function for assignment, returns the right hand side variable to be assigned
     * @exception IOException thrown if there was an error in the tokenizer
     */
    public Variable rhs() throws IOException {
        st.nextToken(); // because identifier does not
        Variable result = identifier();
        return result;
    }

    /**
     * Tries to parse an expression as two arithmetic terms in addition or subtraction
     * @exception IOException thrown if there was an error in the tokenizer
     */
    public SymbolicExpression expression() throws IOException {
        SymbolicExpression result = term();
        st.nextToken();
        while (st.ttype == '+' || st.ttype == '-') {
            if (st.ttype == '+') {
                result = new Addition(result, term());
            } else {
                result = new Subtraction(result, term());
                    }
            st.nextToken();
        }
        st.pushBack();
        return result;
    }

    /**
     * Tries to parse a term and its internal multiplications and divisions
     * @exception IOException thrown if there was an error in the tokenizer
     */
    public SymbolicExpression term() throws IOException {
        SymbolicExpression result = primary();
        st.nextToken();
        while (st.ttype == '*' || st.ttype == '/') {
            if (st.ttype == '*') {
                result = new Multiplication(result, primary());
            } else {
                result = new Division(result, primary());
            }
            st.nextToken();
        }
        st.pushBack();
        return result;
    }

    /**
     * Tries to parse a number value, constant or variable. If primary() parses a parenthesis character it will try to parse an entire new assignment() within the parenthesis
     * @exception IOException thrown if there was an error in the tokenizer
     * @exception SyntaxErrorException thrown if a mismatched parenthesis was parsed
     */
    public SymbolicExpression primary() throws IOException {
        int next = st.nextToken();
        switch (next) {

        case StreamTokenizer.TT_NUMBER:
            return number();

        case StreamTokenizer.TT_WORD:
            if (unaryOperations.contains(st.sval)) {
                return unary();
            } else if (Constants.namedConstants.containsKey(st.sval)){
                return new NamedConstant(Constants.namedConstants.get(st.sval), st.sval);
            } else {
                return identifier();
            }

        case ('('):
            SymbolicExpression result =  assignment();
            if (st.nextToken() == ')') {
                return result;
            } else {
                throw new SyntaxErrorException("Mismatched paranthesis, assignment followed by " + st.ttype);
            }

        case ('-'):
            return unary();


        default:
           throw new SyntaxErrorException("Expected strings, number or paranthesis as primary, got " + st.ttype);
        }
    }

    /**
     * Tries to parse input as a unary mathematical function
     * @exception IOException thrown if there was an error in the tokenizer
     * @exception SyntaxErrorException thrown if the token was not recognized as a valid function
     */
    public SymbolicExpression unary() throws IOException {
         if (st.ttype == '-') {
                return new Negation(primary());
            } else {
             switch (st.sval) {
             case "log":
                 return new Log(primary());
             case "exp":
                 return new Exp(primary());
             case "cos":
                 return new Cos(primary());
             case "sin":
                 return new Sin(primary());
             default:
                 throw new SyntaxErrorException("Expected unary operator, got " + st.sval);
                 }
        }

    }

    /**
     * Helper function for rhs() in assignment(). Tries to parse a Variable.
     * @exception IOException thrown if there was an error in the tokenizer
     * @exception IllegalExpressionException thrown if the token being parsed is already identified as a Named Constant (for example pi)
     * @exception SyntaxErrorException #1 thrown if the token being parsed is a command
     * @exception SyntaxErrorException #2 thrown if the token was not recognized as a string
     */
    public Variable identifier() {
        if (st.ttype == StreamTokenizer.TT_WORD ) {
            if (!commands.contains(st.sval)) {
                if (!Constants.namedConstants.containsKey(st.sval)) {
                     return new Variable(st.sval);
                } else {
                    throw new Assignment.IllegalExpressionException("Can not overwrite named constant " + st.sval);
                }
            } else {
                throw new SyntaxErrorException("Command used as variable: " + st.sval);
            }
        } else {
            throw new SyntaxErrorException("Expected string as identifier, got " + st.ttype);
        }
    }

    /**
     * Tries to parse a number
     * @exception IOException thrown if there was an error in the tokenizer
     * @exception SyntaxErrorException thrown if token was not recognized as a number
     */
    public SymbolicExpression number() {
            if (st.ttype == StreamTokenizer.TT_NUMBER) {
                return new Constant(st.nval);
            } else {
                 throw new SyntaxErrorException("Expected number as number, got " + st.ttype);
            }
    }
}
