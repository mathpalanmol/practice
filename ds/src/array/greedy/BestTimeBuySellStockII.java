package array.greedy;

/**
 * Best Time to Buy and Sell Stock II (LeetCode #122)
 *
 * <p>Same setting as I but unlimited transactions (no overlapping holds). Maximize total profit.
 *
 * <p>Constraints: {@code 1 <= prices.length <= 3 * 10^4}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code profit = 0}.</li>
 *   <li>For {@code i = 1 .. n-1}, if {@code prices[i] &gt; prices[i-1]}, add {@code prices[i] - prices[i-1]}.</li>
 *   <li>Return {@code profit}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  prices = [7, 1, 5, 3, 6, 4]
 * Step:   gains (5-1)+(6-3) = 4+3 = 7
 * Output: 7
 * </pre>
 */
public class BestTimeBuySellStockII {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]; // hold through overnight gain
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit (unlimited): " + maxProfit(prices));
    }
}
