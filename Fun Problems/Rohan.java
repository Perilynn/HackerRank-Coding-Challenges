public class FunProblems {
    double toDouble(String str) {
        return Double.parseDouble(str);
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
