//use Hashtable

import java.util.*;

public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		Hashtable<String, Boolean> hash = new Hashtable<String, Boolean>();
		int l = num.length;
		int k = 1 << l;
		Arrays.sort(num);
		for (int i = 0; i <= k - 1; i++) {
			int j = i;
			solution = new ArrayList<Integer>();
			int m = 0;
			while (j > 0) {
				if ((1 & j) == 1) {
					solution.add(num[m]);
				}
				j >>= 1;
				m++;
			}
			String s = arrayToString(solution);
			if (!hash.containsKey(s)) {
				result.add(solution);
				hash.put(s, true);
			}
		}
		return result;
	}

	public String arrayToString(ArrayList<Integer> list) {
		if (list.size() == 0) {
			return new String();
		}
		int[] num = new int[list.size()];
		for (int i = 0; i < num.length; i++) {
			num[i] = list.get(i);
		}
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num.length; i++) {
			sb.append(num[i]);
		}
		return sb.toString();
	}
}
