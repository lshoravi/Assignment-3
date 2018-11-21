
package org.ioopm.calculator.parser;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import org.ioopm.calculator.ast.*;

public class CalculatorParser {
    private final StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private final List<String> unaryOperations = Arrays.asList("sin", "cos", "log", "exp");
    private final List<String> commands = Arrays.asList("Vars", "Quit", "Clear");
    private final Environment vars = new Environment();

    public CalculatorParser () {
        this.st.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :)
        this.st.eolIsSignificant(true); /// parse end-of-line as ordinary token
    }

    public SymbolicExpression top_level() throws IOException {
        SymbolicExpression result = statement();
        if  (st.nextToken() == StreamTokenizer.TT_EOL) {
            return result;
        } else {
            throw new SyntaxErrorException("Expected EOL after statement, got " + st.ttype);
        }
    }

    public SymbolicExpression statement() throws IOException {
        st.nextToken();
        if (st.ttype == StreamTokenizer.TT_WORD) {
            if ((commands.contains(st.sval))  {
                    return command();
            }
        }
        st.pushBack();
        return assignment();
    }

    public SymbolicExpression command() throws IOException {
         if (st.ttype == StreamTokenizer.TT_WORD) {
             if (st.sval == "Vars") {
                 return Vars.instance();
             }
             else if (st.sval == "Quit") {
                 return Quit.instance();
             }
             else if (st.sval == "Clear") {
                 return Clear.instance();
             }
         }
         throw new SyntaxErrorException("Expected \"Vars\", \"Clear\" or \"Quit\" as command, got " + st.ttype);
    }

    public SymbolicExpression assignment() throws IOException {
        SymbolicExpression result = lhs();
        while (st.nextToken() == '=') {
            Variable id = rhs();
            result = new Assignment(result, id);
        }
        st.pushBack();
        return result;
    }

    public SymbolicExpression lhs() throws IOException {
        return expression();
    }

    public Variable rhs() throws IOException {
        st.nextToken(); // because identifier does not
        Variable result = identifier();
        return result;
    }

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

    public SymbolicExpression primary() throws IOException {
        int next = st.nextToken();
        switch (next) {

        case StreamTokenizer.TT_NUMBER:
            return number();

        case StreamTokenizer.TT_WORD:
            if (unaryOperations.contains(st.sval)) {
                return unary();
            } else {
                return identifier();
            }

        case ('('):
            SymbolicExpression result =  assignment();
            if (st.nextToken() == ')') {
                return result;
            } else {
                throw new SyntaxErrorException("Missmatched paranthesis, assignment followed by " + st.ttype);
            }

        case ('-'):
            return unary();


        default:
           throw new SyntaxErrorException("Expected strings, number or paranthesis as primary, got " + st.ttype);
        }
    }

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

    public Variable identifier() {
        if (st.ttype == StreamTokenizer.TT_WORD ) {
            if (!commands.contains(st.sval)) {
                return new Variable(st.sval);
            } else {
                throw new SyntaxErrorException("Command used as variable: " + st.sval);
            }
        } else {
            throw new SyntaxErrorException("Expected string as identifier, got " + st.ttype);
        }
    }

    public SymbolicExpression number() {
            if (st.ttype == StreamTokenizer.TT_NUMBER) {
                return new Constant(st.nval);
            } else {
                 throw new SyntaxErrorException("Expected number as number, got " + st.ttype);
            }
    }
}
