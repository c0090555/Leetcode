//LCS problem
//DP:use a 2 dimensional array to represent the length of the longest subsequence ending at index i of string s and index j of string t 
//Situations:
//matrix[i][j]= 1) 0 if i<0 || j<0
//            = 2) matrix[i-1][j-1] if x[i]=y[j]
//            = 3) Math.max(matrix[i-1][j],matrix[i][j-1])
//           
//

public class LongestCommonSubsequence {
	public String longestCommonSubsequence(String s, String t) {
		if (s.length() == 0) {
			return new String();
		}
		if (t.length() == 0) {
			return new String();
		}
		int[][] matrix = new int[s.length()][t.length()];
		calculateLongestLength(s,t,matrix);
		return constructLCS(s,t,matrix,s.length()-1,t.length()-1);

	}

	public void calculateLongestLength(String s, String t, int[][] matrix) {
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {// if match, try to find the
													// previous one(diagonal
													// direction)
					if (i == 0 || j == 0) {
						matrix[i][j] = 1;
					} else {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					}
				} else {// if not match, try to search the top and left
						// directions
					if (i == 0 || j == 0) {
						matrix[i][j] = 0;
					} else {
						matrix[i][j] = Math.max(matrix[i - 1][j],
								matrix[i][j - 1]);
					}
				}

			}
		}
	}

	public String constructLCS(String s, String t, int[][] matrix, int i, int j) {
		StringBuilder sb = new StringBuilder();
		if (i < 0 || j < 0) {
			return "";
		}

		if (s.charAt(i) == t.charAt(j)) {
			constructLCS(s, t, matrix, i - 1, j - 1);
			sb.append(s.charAt(i));
		} else {
			if (i == 0 || j == 0) {
				return sb.toString();
			}
			if (matrix[i - 1][j] > matrix[i][j - 1]) {
				constructLCS(s, t, matrix, i - 1, j);
			} else if (matrix[i - 1][j] < matrix[i][j - 1]) {
				constructLCS(s, t, matrix, i, j - 1);
			} else {
				constructLCS(s, t, matrix, i - 1, j);
				constructLCS(s, t, matrix, i, j - 1);
			}

		}
		return sb.toString();

	}

}
