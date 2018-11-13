package org.ioopm.calculator.parser;
import org.ioopm.calculator.ast.*;

public class SyntaxErrorException extends RuntimeException {

    public SyntaxErrorException(String msg) {
        super(msg);
    }
}
