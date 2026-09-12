package array.inplace;

import java.util.Arrays;

/**
 * Rotate Array (LeetCode #189)
 *
 * <p>Given integer array {@code nums}, rotate right by {@code k} steps in-place
 * ({@code k} may be larger than length — use {@code k % n}).
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}; {@code -2^31 <= nums[i] <= 2^31 - 1}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code k %= nums.length}.</li>
 *   <li>Reverse whole array {@code [0 .. n-1]}.</li>
 *   <li>Reverse prefix {@code [0 .. k-1]}.</li>
 *   <li>Reverse suffix {@code [k .. n-1]}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [1,2,3,4,5,6,7], k = 3
 * Step:   reverse all → [7,6,5,4,3,2,1]; reverse [0..2] and [3..6]
 * Output: [5,6,7,1,2,3,4]
 * </pre>
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] a, int lo, int hi) {
        while (lo < hi) {
            int t = a[lo];
            a[lo] = a[hi];
            a[hi] = t;
            lo++;
            hi--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Before: " + Arrays.toString(a));
        rotate(a, 3);
        System.out.println("After:  " + Arrays.toString(a));
    }
}
