package tudelft.sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TwoNumbersSumTest {

    @Test
    void addsSameLengthNumbersWithoutCarry() {
        TwoNumbersSum sut = new TwoNumbersSum();

        ArrayList<Integer> res = sut.addTwoNumbers(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(3, 4))
        );

        assertEquals(Arrays.asList(4, 6), res); // 12 + 34 = 46
    }

    @Test
    void addsSameLengthNumbersWithCarryInMiddle() {
        TwoNumbersSum sut = new TwoNumbersSum();

        ArrayList<Integer> res = sut.addTwoNumbers(
                new ArrayList<>(Arrays.asList(5, 9)),
                new ArrayList<>(Arrays.asList(6, 4))
        );
s
        assertEquals(Arrays.asList(1, 2, 3), res); // 59 + 64 = 123
    }

    @Test
    void addsDifferentLengthNumbers() {
        TwoNumbersSum sut = new TwoNumbersSum();

        ArrayList<Integer> res = sut.addTwoNumbers(
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(9))
        );

        assertEquals(Arrays.asList(1, 3, 2), res); // 123 + 9 = 132
    }

    @Test
    void addsFinalCarry() {
        TwoNumbersSum sut = new TwoNumbersSum();

        ArrayList<Integer> res = sut.addTwoNumbers(
                new ArrayList<>(Arrays.asList(9, 9, 9)),
                new ArrayList<>(Arrays.asList(1))
        );

        assertEquals(Arrays.asList(1, 0, 0, 0), res); // 999 + 1 = 1000
    }

    @Test
    void doesNotMutateInputLists() {
        TwoNumbersSum sut = new TwoNumbersSum();

        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(4, 5));

        sut.addTwoNumbers(first, second);

        assertEquals(Arrays.asList(1, 2, 3), first);
        assertEquals(Arrays.asList(4, 5), second);
    }
}
