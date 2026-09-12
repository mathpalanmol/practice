package array.prefixsum;

/**
 * Maximum Product Subarray (LeetCode #152)
 *
 * <p>Given integer array {@code nums}, find a contiguous subarray whose product is maximum
 * and return that product.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 2 * 10^4}; values in {@code [-10, 10]}.
 * Negative × negative can become a large positive — track both max and min product ending here.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code best = max = min = nums[0]}.</li>
 *   <li>For {@code i = 1 .. n-1}, {@code x = nums[i]}; if {@code x &lt; 0}, swap {@code max} and {@code min}.</li>
 *   <li>{@code max = max(x, max * x)}; {@code min = min(x, min * x)}; {@code best = max(best, max)}.</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [2, 3, -2, 4]
 * Step:   max ending at index 1 is 6 → best 6
 * Output: 6
 * </pre>
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int best = nums[0];
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                int t = max;
                max = min;
                min = t; // negative flips which end is max vs min
            }
            max = Math.max(x, max * x);
            min = Math.min(x, min * x);
            best = Math.max(best, max);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Max product subarray: " + maxProduct(nums));
    }
}
