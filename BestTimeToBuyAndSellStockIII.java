/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
//idea comes from peking2 of Mitbbs
// use two array dp1 and dp2 to traversal from both end

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int len = prices.length;
		int[] dp1 = new int[prices.length];
		int[] dp2 = new int[prices.length];
		int min = prices[0];
		int max = prices[len - 1];

		// for dp1: travel from left to right
		System.out.print(" " + dp1[0]);

		for (int i = 1; i < len; i++) {
			min = Math.min(min, prices[i]);
			dp1[i] = Math.max(dp1[i - 1], prices[i] - min);
			System.out.print(" " + dp1[i]);
		}
		System.out.println();
		// for dp2: travel from right to left
		System.out.print(" " + dp2[len - 1]);
		for (int j = len - 2; j >= 0; j--) {
			max = Math.max(max, prices[j]);
			dp2[j] = Math.max(dp2[j + 1], max - prices[j]);
			System.out.print(" " + dp2[j]);
		}
		System.out.println();
		int ans = 0;
		for (int k = 0; k < len; k++) {
			ans = Math.max(ans, dp1[k] + dp2[k]);// You may not engage in
													// multiple transactions at
													// the same time
		}
		return ans;

	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII o = new BestTimeToBuyAndSellStockIII();
		int[] prices = { 2, 1, 2, 1, 0, 1, 2 };
		System.out.println(o.maxProfit(prices));
	}
}
