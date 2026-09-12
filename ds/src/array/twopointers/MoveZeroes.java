package array.twopointers;

import java.util.Arrays;

/**
 * Move Zeroes (LeetCode #283)
 *
 * <p>Given integer array {@code nums}, move all {@code 0}'s to the end while keeping the
 * relative order of non-zero elements. Must be in-place without making a copy.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^4}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code write = 0} (next index for a non-zero).</li>
 *   <li>For each {@code x} in {@code nums}, if {@code x != 0}, assign {@code nums[write++] = x}.</li>
 *   <li>While {@code write &lt; nums.length}, set {@code nums[write++] = 0}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [0, 1, 0, 3, 12]
 * Step:   compact → [1,3,12]; pad → [1,3,12,0,0]
 * Output: [1, 3, 12, 0, 0]
 * </pre>
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int write = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[write++] = x;
            }
        }
        while (write < nums.length) {
            nums[write++] = 0; // pad tail with zeros
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(a));
        moveZeroes(a);
        System.out.println("After:  " + Arrays.toString(a));
    }
}
