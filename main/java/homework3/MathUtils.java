package homework3;

public class MathUtils {

    private final static int MIN_LIMIT = 25;
    private final static int MAX_LIMIT = 100;

    public static boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    public static boolean numberInInterval(int n) {
        return n > MIN_LIMIT && n < MAX_LIMIT;
    }
}
