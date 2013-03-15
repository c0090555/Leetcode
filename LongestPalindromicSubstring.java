//basic idea: reverse the string and find the longest common substring between the original and reversed strings
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s.length() == 0) {
			return new String();
		}
		String t = reverseString(s);
		return longestCommonSubstring(s, t);
	}

	public String reverseString(String s) {
		if (s.length() == 0) {
			return new String();
		}
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			sb.append(charArray[i]);
		}
		return sb.toString();
	}

	public String longestCommonSubstring(String s, String t) {
		int[][] matrix = new int[s.length()][t.length()];
		int maxLen = 0;
		int lastSubStart = 0;
		int currentSubStart = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {// character matching
					if (i == 0 || j == 0) {// initialize the first row and
											// column to 1
						matrix[i][j] = 1;
					} else {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					}
					if (matrix[i][j] > maxLen) {
						maxLen = matrix[i][j];// update maxLen
						currentSubStart = i - matrix[i][j] + 1;
						if (currentSubStart == lastSubStart) {// if we are in
																// the same
																// substring
							sb.append(s.charAt(i));
						} else {// we are creating a new substring, so we need
								// to clear sb first
							sb = new StringBuilder();// clear sb
							lastSubStart = currentSubStart;
							sb.append(s.subSequence(currentSubStart, i + 1));// append
																				// current
																				// longest
																				// substring
						}

					}

				}
			}
		}
		return sb.toString();

	}

}
