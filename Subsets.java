//idea comes from: https://github.com/anson627/leetcode/blob/master/Subsets/Subsets.cpp
//use bit manipulation

import java.util.*;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution = new ArrayList<Integer>();
		Arrays.sort(S);
		int l = S.length;
		int k = 1 << l;
		for (int i = 0; i <= k - 1; i++) {
			int j = i;
			solution = new ArrayList<Integer>();
			int m = 0;
			while (j > 0) {
				if ((1 & j) == 1) {
					solution.add(S[m]);
				}
				j >>= 1;
				m++;
			}

			result.add(solution);
		}
		return result;

	}
}
