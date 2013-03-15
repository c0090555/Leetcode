//idea comes from: https://github.com/anson627/leetcode/blob/master/UniqueBinarySearchTrees/UniqueBinarySearchTrees.cpp

//DP, dp[n] is numbers of BSTs for n nodes
//we have a list of n numbers, assuming [1..n]
//if we select 1 as the root, the 0 nodes left in left BST and n-1 nodes in right BST, dp += dp[0]+dp[n-1]
//

public class UniqueBinarySearchTree {
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0 || n == 1) {
			return 1;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];

	}
}
