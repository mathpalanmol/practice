package array.prefixsum;

/**
 * Maximum Subarray (LeetCode #53) — Kadane's algorithm
 *
 * <p>Given integer array {@code nums}, find the contiguous subarray with the largest sum
 * and return that sum. At least one element is in the subarray.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}; values in {@code [-10^4, 10^4]}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code best = nums[0]}, {@code cur = 0}.</li>
 *   <li>For each {@code x}: {@code cur = max(x, cur + x)} (extend prior subarray or restart at {@code x}).</li>
 *   <li>{@code best = max(best, cur)}.</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * Step:   peak cur at subarray [4,-1,2,1] → sum 6
 * Output: 6
 * </pre>
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int best = nums[0];
        int cur = 0;
        for (int x : nums) {
            cur = Math.max(x, cur + x); // extend or restart at x
            best = Math.max(best, cur);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum: " + maxSubArray(nums));
    }
}
