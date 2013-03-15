//The idea comes from:http://www.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
//use two pointers begin and end to point to the beginning and end of the window
//use tow tables hasFound[] and needToFind[]: 
//needToFind[] stores the total count of a character in T
//hasFound[] stores the total count of a character met so far
//use a count to store the total characters that's met so far
//The time complexity of this algorithm: O(n)

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0) {
			return "";
		}
		if (T.length() == 0) {
			return S;
		}
		int begin = 0;
		int end = 0;
		int[] needToFind = new int[256];// 256 is good enough for regular
										// characters
		int[] hasFound = new int[256];
		int count = 0;
		for (int i = 0; i < T.length(); i++) {// initialization of needToFind
												// table
			needToFind[(int) T.charAt(i)]++;
		}

		int minLen = Integer.MAX_VALUE;
		int minBegin = -1;
		int minEnd = -1;
		for (begin = 0, end = 0; end < S.length(); end++) {
			if (needToFind[(int) S.charAt(end)] == 0) {// if element pointed by
														// end is not in T, skip
														// it
				continue;
			}
			hasFound[(int) S.charAt(end)]++;
			if (hasFound[(int) S.charAt(end)] <= needToFind[(int) S.charAt(end)]) {
				count++;
			}

			// if window constraint is satisfied
			if (count == T.length()) {
				// move the begin as right as possible
				while (needToFind[(int) S.charAt(begin)] == 0
						|| hasFound[(int) S.charAt(begin)] > needToFind[(int) S
								.charAt(begin)]) {
					if (hasFound[(int) S.charAt(begin)] > needToFind[(int) S
							.charAt(begin)]) {
						hasFound[(int) S.charAt(begin)]--;
					}
					begin++;
				}
				int currentLen = end - begin + 1;
				if (currentLen < minLen) {
					minLen = currentLen;
					minBegin = begin;
					minEnd = end;
				}

			}

		}
		if (minBegin == -1) {// window not found
			return "";
		} else {
			return S.substring(minBegin, minEnd + 1);
		}
	}
}
