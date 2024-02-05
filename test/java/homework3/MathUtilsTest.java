package homework3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {-10, -4, 0, 6, 24, Integer.MIN_VALUE})
    void testEvenNumbers(int n) {
        assertTrue(MathUtils.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-11, -5, 7, 23, Integer.MAX_VALUE})
    void testOddNumbers(int n) {
        assertFalse(MathUtils.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {29, 45, 66, 93})
    void testNumberExistInInterval(int n) {
        assertTrue(MathUtils.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {20, -45, 106, -101, 0})
    void testNumberDoNotExistInInterval(int n) {
        assertFalse(MathUtils.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 99})
    void testMinMaxLimitExistInInterval(int n) {
        assertTrue(MathUtils.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    void testMinMaxLimitDoNotExistInInterval(int n) {
        assertFalse(MathUtils.numberInInterval(n));
    }
}
