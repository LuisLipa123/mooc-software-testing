package tudelft.sum;

import java.util.ArrayList;
import java.util.Collections;

// Source: https://leetcode.com/problems/add-two-numbers/description/
class TwoNumbersSum {

    public ArrayList<Integer> addTwoNumbers(ArrayList<Integer> first, ArrayList<Integer> second) {
        // Avoid mutating input lists (side effects)
        ArrayList<Integer> a = new ArrayList<>(first);
        ArrayList<Integer> b = new ArrayList<>(second);

        Collections.reverse(a);
        Collections.reverse(b);

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.max(a.size(), b.size()); i++) {
            int firstVal = i < a.size() ? a.get(i) : 0;
            int secondVal = i < b.size() ? b.get(i) : 0;

            int total = firstVal + secondVal + complement;
            complement = total / 10;
            total = total % 10;

            result.add(total);
        }

        // If there's still a carry, add it
        if (complement > 0) {
            result.add(complement);
        }

        Collections.reverse(result);
        return result;
    }
}
