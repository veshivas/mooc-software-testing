package tudelft.sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TwoNumbersSumTest {
    @Test
    public void numbers_without_zero() {
        Integer[] one = {1, 2};
        Integer[] two = {3, 4};
        TwoNumbersSum sum_num = new TwoNumbersSum(one,two);
        ArrayList<Integer> result = sum_num.addTwoNumbers();
        Integer[] expected = {4, 6};
        Assertions.assertArrayEquals(expected,result.toArray());
    }
    @Test
    public void numbers_with_zero() {
        Integer[] one = {1, 0, 3};
        Integer[] two = {2, 2, 8};
        TwoNumbersSum sum_num = new TwoNumbersSum(one, two);
        ArrayList<Integer> result = sum_num.addTwoNumbers();
        Integer[] expected = {3, 3, 1};
        Assertions.assertArrayEquals(expected,result.toArray());
    }
    @Test
    public void numbers_non_matchng_digits() {
        Integer[] one = {1, 2, 3};
        Integer[] two = {9, 8};
        TwoNumbersSum sum_num = new TwoNumbersSum(one, two);
        ArrayList<Integer> result = sum_num.addTwoNumbers();
        Integer[] expected = {2, 2, 1};
        Assertions.assertArrayEquals(expected,result.toArray());
    }
}
