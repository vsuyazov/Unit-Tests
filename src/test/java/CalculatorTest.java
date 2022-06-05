import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    Calculator calculator = Calculator.instance.get();

    @Test
    public void testCalculator() {

        int a = 5, b = 6, expectedResult = 11;

        int result = calculator.plus.apply(a, b);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void testParamMethodSource(int x, int y, int expectedResult) {

        int result = calculator.divide.apply(x, y);

        Assertions.assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("methodSourcePow")
    public void testParamMethodSourcePow(int x, int expectedResult) {

        int resultPow = calculator.pow.apply(x);

        Assertions.assertEquals(expectedResult, resultPow);
    }

    public static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(10, 5, 2),
                Arguments.of(30, 6, 5),
                Arguments.of(49, 7, 7),
                Arguments.of(4, 0, 0)
        );
    }

    public static Stream<Arguments> methodSourcePow() {
        return Stream.of(
                Arguments.of(5, 25),
                Arguments.of(6, 36),
                Arguments.of(8, 64)
        );
    }
}
