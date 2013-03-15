import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (numbers.length == 0) {
			return null;
		}
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		int[] result = new int[2];
		int small = 0;
		int big = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (!hash.containsKey(numbers[i])) {
				hash.put(target - numbers[i], i);
			} else {
				small = i < hash.get(numbers[i]) ? i : hash.get(numbers[i]);
				big = small == i ? hash.get(numbers[i]) : i;

			}
		}
		result[0] = small + 1;
		result[1] = big + 1;
		return result;

	}
}
