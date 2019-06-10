package ary;

// buy and sell one time and get max profit.

public class StockBuySellOneTime {
	static int[] ary = { 100, 80, 120, 130, 70, 60, 100, 125 };

	public static void main(String[] args) {

		int res = getProfit(ary);
		System.out.println(res);
	}

	private static int getProfit(int[] ary) {
		int maxProfit = Integer.MIN_VALUE;
		int minVal = Integer.MAX_VALUE;

		for (int i = 0; i < ary.length; i++) {
			minVal = Math.min(minVal, ary[i]);
			maxProfit = Math.max(maxProfit, ary[i] - minVal);
		}

		return maxProfit;
	}

}
