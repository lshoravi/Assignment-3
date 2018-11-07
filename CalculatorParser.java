

import java.io.StreamTokenizer;
import java.io.IOException;

public class CalculatorParser {
    private final StreamTokenizer st = new StreamTokenizer(System.in);

    public CalculatorParser() {
        /// We want to treat - and end of line as an ordinary tokens
        this.st.ordinaryChar('-'); /// parse object-oriented as "object" - "oriented" :)
        this.st.eolIsSignificant(true);
    }

    public SymbolicExpression expression() {
        SymbolicExpression result = term();
        while (st.ttype == '+' || st.ttype == '-') {
            int operation = st.ttype;
            st.nextToken();
            if (operation == '+') {
                result = new Addition(result, term());
            } else {
                result = new SymbolicExpression("Subtraction", result, term());
            }
        }
        return result;
    }

    /// This method works like expression, but with factors and * instead of terms and +/-
    private double term() throws IOException {
        double prod = factor();
        while (this.st.nextToken() == '*') {
            prod *= factor();
        }
        this.st.pushBack();
        return prod;
    }

    private double factor() throws IOException {
        double result;
        /// If we encounter a (, we know we are reading a full expression, so we call back up
        /// to that method, and then try to read a closing ) at the end
        if (this.st.nextToken() == '('){
            result = expression();
            /// This captures unbalanced parentheses!
            if (this.st.nextToken() != ')') {
                throw new SyntaxErrorException("expected ')'");
            }
        } else {
            this.st.pushBack();
            result = number();
        }
        return result;
    }

    private double number() throws IOException {
        if (this.st.nextToken() == this.st.TT_NUMBER) {
            return this.st.nval;
        } else {
            throw new SyntaxErrorException("Expected number");
        }
    }
}
