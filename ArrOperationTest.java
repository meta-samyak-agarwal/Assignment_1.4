
import org.junit.internal.ArrayComparisonFailure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

import java.util.stream.Stream;

public class ArrOperationTest {

    private static Stream<Arguments> inputsAndResults1() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 4}, 3),
                Arguments.of(new int[]{1, 4, 5, 3, 5, 4, 1}, 7),
                Arguments.of(new int[]{7, 1, 4, 9, 7, 4, 1}, 2),
                Arguments.of(new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3));
    }

    @ParameterizedTest
    @MethodSource("inputsAndResults1")
    public void testLargest(int[] arr, int expectedResult) {
        ArrOperation lm = new ArrOperation();

        assertEquals(expectedResult, lm.largestMirror(arr));

    }

    // Exception wala for largestOne
    @Test
    public void testLargestException() {
        ArrOperation lm = new ArrOperation();
        int[] arr = {};

        assertThrows(AssertionError.class, () -> lm.largestMirror(arr));
    }

    // clumps tests
    private static Stream<Arguments> inputsAndResults2() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 4, 4}, 2),
                Arguments.of(new int[]{1, 1, 2, 1, 1}, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1),
                Arguments.of(new int[]{1, 2, 2, 2, 2, 1}, 1));

    }

    @ParameterizedTest
    @MethodSource("inputsAndResults2")
    public void testClumps(int[] arr, int expectedResult) {
        ArrOperation lm = new ArrOperation();

        assertEquals(expectedResult, lm.clumps(arr));

    }

    // Exception wala for clumps
    @Test
    public void testClumpsException() {
        ArrOperation lm = new ArrOperation();
        int[] arr = {};

        assertThrows(AssertionError.class, () -> lm.clumps(arr));
    }



    // findXY tests
    private static Stream<Arguments> inputsAndResults3() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 9, 4, 9, 5}, 4 , 5, new int[]{9, 4, 5, 4, 5, 9}),
                Arguments.of(new int[]{1, 4, 1, 5}, 4, 5 ,new int[]{1, 4, 5, 1}),
                Arguments.of(new int[]{1, 4, 1, 5, 5, 4, 1}, 4 , 5, new int[]{1, 4, 5, 1, 1, 4, 5}));
    }

    @ParameterizedTest
    @MethodSource("inputsAndResults3")
    public void testFixXY(int[] arr, int X , int Y, int[] expectedResult) {
        ArrOperation lm = new ArrOperation();

        assertArrayEquals(expectedResult, lm.fixXY(arr, X, Y));

    }

    // findXY  Exception 
    private static Stream<Arguments> inputsAndResults7() {
        return Stream.of(
                Arguments.of(new int[]{4, 4, 5, 5, 5}, 4, 5),
                Arguments.of(new int[]{1, 5, 1, 4}, 4, 5),
                Arguments.of(new int[]{}, 4, 5));
    }

    @ParameterizedTest
    @MethodSource("inputsAndResults7")
    public void testFixXYException(int[] arr, int X, int Y) {
        ArrOperation lm = new ArrOperation();

        assertThrows(AssertionError.class, () -> lm.fixXY(arr, X, Y));
    }

    // splitwala tests 
    private static Stream<Arguments> inputsAndResults4() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 3}, 3),
                Arguments.of(new int[]{1, 1, 1, 2, 1}, 3),
                Arguments.of(new int[]{2, 1, 1, 2, 1}, -1),
                Arguments.of(new int[]{10, 10}, 1));

    }

    @ParameterizedTest
    @MethodSource("inputsAndResults4")
    public void testSplit(int[] arr, int expectedResult) {
        ArrOperation lm = new ArrOperation();

        assertEquals(expectedResult, lm.splitArray(arr));

    }

    // Exception wala for split array
    @Test
    public void testSplitException() {
        ArrOperation lm = new ArrOperation();
        int[] arr = {};

        assertThrows(AssertionError.class, () -> lm.splitArray(arr));
    }

}
