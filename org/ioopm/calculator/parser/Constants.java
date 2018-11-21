package org.ioopm.calculator.parser;

import java.util.HashMap;
import org.ioopm.calculator.ast.*;

public class Constants {
    public static final HashMap<String, Double> namedConstants = new HashMap<>();

    static {
        Constants.namedConstants.put("pi", Math.PI);
        Constants.namedConstants.put("e",  Math.E);
        Constants.namedConstants.put("L",  (6.022140857* Math.pow(10, 23)));
        Constants.namedConstants.put("answer",  42.0);

        /// TODO: the rest of the constants, go wild!
    }
}
