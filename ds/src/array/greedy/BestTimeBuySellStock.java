package array.greedy;

/**
 * Best Time to Buy and Sell Stock (LeetCode #121)
 *
 * <p>Given prices {@code prices[i]} for day {@code i}, pick one buy day and one later sell day
 * to maximize profit. Return max profit; if none, return 0.
 *
 * <p>Constraints: {@code 1 <= prices.length <= 10^5}; one transaction only.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code min = Integer.MAX_VALUE}, {@code best = 0}.</li>
 *   <li>For each price {@code p}: {@code min = min(min, p)}; {@code best = max(best, p - min)}.</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  prices = [7, 1, 5, 3, 6, 4]
 * Step:   min 1 at day 1; best profit 6-1=5
 * Output: 5
 * </pre>
 */
public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int best = 0;
        for (int p : prices) {
            min = Math.min(min, p);
            best = Math.max(best, p - min);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit: " + maxProfit(prices));
    }
}
