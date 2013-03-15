//idea comes from:https://github.com/anson627/leetcode/blob/master/UniquePaths/UniquePaths.cpp
//DP
//dp[x][y]=dp[x-1][y]+dp[x][y-1]

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int i = 1; i < m; i++) {// first column
			dp[i][0] = dp[i - 1][0];
		}
		for (int j = 1; j < n; j++) {// first row
			dp[0][j] = dp[0][j - 1];
		}
		for (int i = 1; i < m; i++) {// middle part
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];

	}

}
