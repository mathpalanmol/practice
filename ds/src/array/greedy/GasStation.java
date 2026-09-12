package array.greedy;

/**
 * Gas Station (LeetCode #134)
 *
 * <p>There are {@code n} gas stations in a circle; {@code gas[i]} fuel and {@code cost[i]} to
 * reach next station. Start with empty tank at some index; return starting index if you can
 * complete the circuit once, else {@code -1}. If a solution exists it is unique.
 *
 * <p>Constraints: equal length arrays; {@code 1 <= n <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code total = 0}, {@code tank = 0}, {@code start = 0}.</li>
 *   <li>For each {@code i}, {@code diff = gas[i] - cost[i]}; add to {@code total} and {@code tank}.</li>
 *   <li>If {@code tank &lt; 0}, set {@code start = i + 1}, {@code tank = 0}.</li>
 *   <li>Return {@code start} if {@code total &gt;= 0}, else -1.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Step:   total surplus ≥ 0; last viable start index 3
 * Output: 3
 * </pre>
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1; // failed from old start through i — try next station
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Start index: " + canCompleteCircuit(gas, cost));
    }
}
