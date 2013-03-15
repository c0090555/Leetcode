/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int max = 0;
		for (int i = 1; i < prices.length; i++) {
			for (int j = 0; j < i; j++) {
				if (prices[i] > prices[j]) {
					int value = prices[i] - prices[j];
					max = Math.max(max, value);
				}
			}
		}

		return max;
	}
}
