/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"
Return 3. 
Let the three b's in "rabbbit" be labeled as b1, b2, and b3. Then there can be 3 distinct subsequences of "rabbit", that is: rab1b2it, rab1b3it, and rab2b3it.
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length() == 0 || S.length() < T.length()) {
			return 0;
		}
		if (T.length() == 0) {
			return 1;
		}
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		for (int j = 0; j <= T.length(); j++) {
			dp[0][j] = 0;
		}
		for (int i = 0; i <= S.length(); i++) {// dp[0][0]==1
			dp[i][0] = 1;
		}

		for (int j = 1; j <= T.length(); j++) {
			for (int i = 1; i <= S.length(); i++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[S.length()][T.length()];

	}

	public static void main(String[] args) {
		DistinctSubsequences o = new DistinctSubsequences();
		String S = "rabbbbit";
		String T = "rabbit";
		System.out.println(o.numDistinct(S, T));
	}
}
