import java.util.*;

public class ClimbingStairs {
	Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();//this hashtable is used to cache the results and has to be defined outside of the method

	public int climbStairs(int n) {

		int sum = 0;
		if (hash.containsKey(n)) {
			return hash.get(n);
		}
		// using DP
		if (n == 1) {
			if (!hash.containsKey(n)) {
				hash.put(1, 1);
			}
			return 1;
		} else if (n == 2) {
			if (!hash.containsKey(n)) {
				hash.put(2, 2);
			}
			return 2;
		}
		if (n <= 0) {
			if (!hash.containsKey(n)) {
				hash.put(n, 0);
			}
			return 0;
		}
		sum = climbStairs(n - 1) + climbStairs(n - 2);
		if (!hash.containsKey(n)) {
			hash.put(n, sum);
		}
		return sum;
	}

}
