import java.lang.*;
import java.util.*;

public class FunProblems {
    int toInt(String str) {
        return Integer.parseInt(str);
    }

    String toString(double x) {
        return String.valueOf(x);
    }

    boolean isNumber(String str) {
        try {
            double x = Double.parseDouble(str);
        } catch(NumberFormatException e) {
            return false;
        }

        return true;
    }
}
