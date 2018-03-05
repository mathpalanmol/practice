package stock;
//Given an array representing prices of the stock on different days, find the maximum profit that can be earned by performing maximum of one transaction. A transaction consists of activity of buying and selling the stock on different or same days. 
//For example in this array - {100, 80, 120, 130, 70, 60, 100, 125} the price of the stock on day-1 is 100, on day-2 is 80 and so on. The maximum profit that could be earned in this window is 65 (buy at 60 and sell at 125).
//
//For price array - {100, 80, 70, 65, 60, 55, 50}, maximum profit that could be earned is 0.
public class StockBuySell {

	static int maxProfit = Integer.MIN_VALUE;
	static int[] ary = { 100, 80, 120, 130, 70, 60, 100, 125 };

	public static int calProfite() {
		int i = 0;
		while (i < ary.length - 1) {
			boolean temp = false;
			while (ary[i] > ary[i + 1]) {
				i++;
				if (i == ary.length - 1){
					temp = true;
					break;}
			}
			if (!temp) {
				int buy = ary[i];
				while (ary[i + 1] > ary[i]) {
					i++;
					if (i == ary.length - 1){
						temp = true;
						break;}
				}
				int sell = ary[i];
				int profit = sell - buy;
				if (profit > maxProfit)
					maxProfit = profit;
			}

			if (temp)
				break;

		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(calProfite());
	}

}
