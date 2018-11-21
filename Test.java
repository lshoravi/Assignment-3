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

    public static void testEvaluating(SymbolicExpression expected, SymbolicExpression e, Environment vars) {
        SymbolicExpression r = e.eval(vars);
        if (r.equals(expected)) {
            System.out.println("Passed: " + e + " = " + expected);
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
        Environment vars = new Environment();
        System.out.println("(5 + x) * 2 ==> " + m);
        testPrinting("(5 + x) * 2", m);

        SymbolicExpression add = new Addition(new Constant(5), new Constant(37));
        SymbolicExpression cons = new Constant(42);
        testEvaluating(cons, add, vars); /// Tests if reducing a returns b (it should!)
        
        vars = new Environment();
        SymbolicExpression mul = new Multiplication(new Addition(new Constant(2), new Constant(4)), new Constant(3));
        testEvaluating(new Constant(18), mul, vars);
        
        vars = new Environment();
        Assignment ass = new Assignment(new Constant(42), new Variable("x"));
        
        SymbolicExpression div = new Division(ass, new Constant(6));
        testEvaluating(new Constant(7), div, vars);

        vars = new Environment();
        SymbolicExpression neg = new Negation(new Constant(42));
        testEvaluating(new Constant(-42), neg, vars);

        vars = new Environment();
        SymbolicExpression assTest = new Assignment(new Constant(2), new Variable("y"));
        testEvaluating(new Constant(2), assTest, vars);
        
        vars = new Environment();
        SymbolicExpression ass2 = new Assignment(new Constant(Math.PI), new Variable("x"));
        SymbolicExpression sin = new Sin(ass2);
        testEvaluating(new Constant(0), sin, vars);
    }
}
