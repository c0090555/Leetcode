/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

//the problem is actually to find all non-decreasing continuous subsequence

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int value = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] <= prices[i + 1]) {
				value += prices[i + 1] - prices[i];
			}
		}
		return value;

	}
}
