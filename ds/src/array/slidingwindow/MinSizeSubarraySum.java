package array.slidingwindow;

/**
 * Minimum Size Subarray Sum (LeetCode #209)
 *
 * <p>Given array of positive integers {@code nums} and positive integer {@code target}, return
 * the minimal length of a contiguous subarray whose sum is {@code >= target}. Return {@code 0}
 * if none exists.
 *
 * <p>Constraints: {@code 1 <= target, nums.length <= 10^5}; all {@code nums[i] >= 1}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code left = 0}, {@code sum = 0}, {@code best = Integer.MAX_VALUE}.</li>
 *   <li>For each {@code right}, {@code sum += nums[right]}.</li>
 *   <li>While {@code sum >= target}: {@code best = min(best, right - left + 1)}; {@code sum -= nums[left++]}.</li>
 *   <li>Return {@code 0} if {@code best} unchanged, else {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  target = 7, nums = [2, 3, 1, 2, 4, 3]
 * Step:   sum≥7 at [4,3] → length 2
 * Output: 2
 * </pre>
 */
public class MinSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, best = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                best = Math.min(best, right - left + 1);
                sum -= nums[left++]; // try shorter window while still valid
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println("Min length: " + minSubArrayLen(7, nums));
    }
}
