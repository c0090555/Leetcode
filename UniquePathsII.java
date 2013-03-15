//another version of unique paths problem
//Attention: if obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1 then just return 0
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 0 || n == 0) {
			return 0;
		}
		int[][] dp = new int[m][n];
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		} else {
			dp[0][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = dp[i - 1][0];
			} else {
				dp[i][0] = 0;
			}
		}
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 0) {
				dp[0][j] = dp[0][j - 1];
			} else {
				dp[0][j] = 0;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
