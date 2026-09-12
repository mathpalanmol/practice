package array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K (LeetCode #560)
 *
 * <p>Given integer array {@code nums} and integer {@code k}, return the number of contiguous
 * subarrays whose sum equals {@code k}.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 2 * 10^4}; values and {@code k} fit in int.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Map {@code freq}: prefix sum → count; {@code freq.put(0, 1)}.</li>
 *   <li>For each {@code x}, {@code sum += x}; {@code count += freq.getOrDefault(sum - k, 0)}.</li>
 *   <li>{@code freq.merge(sum, 1, Integer::sum)}.</li>
 *   <li>Return {@code count}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  nums = [1, 1, 1], k = 2
 * Step:   prefix sums 1,2,3 → two prior sums equal sum-2
 * Output: 2
 * </pre>
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // empty prefix — subarray from start counts
        int sum = 0, count = 0;
        for (int x : nums) {
            sum += x;
            count += freq.getOrDefault(sum - k, 0);
            freq.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println("Subarrays with sum 2: " + subarraySum(nums, 2));
    }
}
