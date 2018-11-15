import org.ioopm.calculator.ast.*;
import java.util.HashMap;

public class Test {
    public static void testPrinting(String expected, SymbolicExpression e) {
        if (expected.equals("" + e)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }

    public static void testEvaluating(SymbolicExpression expected, SymbolicExpression e, HashMap<String,SymbolicExpression> vars) {
        SymbolicExpression r = e.eval(vars);
        if (r.equals(expected)) {
            System.out.println("Passed: " + e);
        } else {
            System.out.println("Error: expected '" + expected + "' but got '" + e + "'");
        }
    }


    public static void main(String[] args) {
        Constant c1 = new Constant(5);
        Constant c2 = new Constant(2);
        Variable v = new Variable("x");
        Addition a = new Addition(c1, v);
        Multiplication m = new Multiplication(a, c2);
        HashMap<String,SymbolicExpression> vars = new HashMap<String,SymbolicExpression>();
        System.out.println("(5 + x) * 2 ==> " + m);
        testPrinting("(5 + x) * 2", m);

        SymbolicExpression ass = new Addition(new Constant(5), new Constant(37));
        SymbolicExpression cons = new Constant(42);
        testEvaluating(cons, ass, vars); /// Tests if reducing a returns b (it should!)


    }
}
