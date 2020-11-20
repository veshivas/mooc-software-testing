package tudelft.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Source: https://leetcode.com/problems/add-two-numbers/description/
class TwoNumbersSum {
    private ArrayList<Integer> list_one;
    private ArrayList<Integer> list_two;

    public TwoNumbersSum(Integer[] first, Integer[] second) {
        assert (first[0] != 0 || second[0] != 0);
        this.list_one = new ArrayList<Integer>();
        this.list_one.addAll(Arrays.asList(first));
        this.list_two = new ArrayList<Integer>();
        this.list_two.addAll(Arrays.asList(second));
    }

    public ArrayList<Integer> addTwoNumbers() {
        ArrayList<Integer> first = this.list_one;
        ArrayList<Integer> second = this.list_two;
        Collections.reverse(first);
        Collections.reverse(second);

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < Math.max(first.size(), second.size()); i++){
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            int total = firstVal + secondVal + complement;
            complement = 0;
            if (total >= 10){
                complement = 1;
                total -= 10;
            }
            result.add(i, total);
        }

        Collections.reverse(result);
        return result;
    }
}
