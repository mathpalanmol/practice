package array.prefixsum;

import java.util.Arrays;

/**
 * Product of Array Except Self (LeetCode #238)
 *
 * <p>Given integer array {@code nums}, return array {@code answer} where {@code answer[i]} is
 * the product of all elements except {@code nums[i]}. Solve without division and in
 * {@code O(n)} with {@code O(1)} extra space (output array does not count).
 *
 * <p>Constraints: {@code 2 <= nums.length <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Allocate {@code out[n]}; set {@code out[0] = 1}.</li>
 *   <li>Left pass: for {@code i = 1 .. n-1}, {@code out[i] = out[i-1] * nums[i-1]} (prefix product excluding self).</li>
 *   <li>Set {@code suffix = 1}; right pass for {@code i = n-1 .. 0}: {@code out[i] *= suffix}; {@code suffix *= nums[i]}.</li>
 *   <li>Return {@code out}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1) extra (output excluded)
 *
 * <pre>
 * Input:  nums = [1, 2, 3, 4]
 * Step:   left [1,1,2,6]; multiply suffix → [24,12,8,6]
 * Output: [24, 12, 8, 6]
 * </pre>
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        out[0] = 1;
        for (int i = 1; i < n; i++) {
            out[i] = out[i - 1] * nums[i - 1]; // prefix product excluding self
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            out[i] *= suffix;
            suffix *= nums[i]; // suffix product of elements after i
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Product except self: " + Arrays.toString(productExceptSelf(nums)));
    }
}
