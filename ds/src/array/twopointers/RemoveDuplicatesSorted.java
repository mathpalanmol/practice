package array.twopointers;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array (LeetCode #26)
 *
 * <p>Given sorted array {@code nums} in non-decreasing order, remove duplicates in-place so
 * each unique element appears once. Return {@code k}, the count of unique elements; the
 * first {@code k} slots of {@code nums} hold those values (order preserved).
 *
 * <p>Constraints: {@code 1 <= nums.length <= 3 * 10^4}; {@code -100 <= nums[i] <= 100}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>If empty, return 0. Set {@code k = 1} (length of unique prefix; index 0 always kept).</li>
 *   <li>For {@code i = 1 .. n-1}, if {@code nums[i] != nums[k - 1]}, copy {@code nums[i]} to {@code nums[k++]}.</li>
 *   <li>Return {@code k}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [1, 1, 2]
 * Step:   i=2 differs from nums[0] → nums[1]=2, k=2
 * Output: k = 2, nums = [1, 2, _]
 * </pre>
 */
public class RemoveDuplicatesSorted {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1; // length of unique prefix
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) { // new value vs last written unique
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int k = removeDuplicates(a);
        System.out.println("Length: " + k + ", nums: " + Arrays.toString(Arrays.copyOf(a, k)));
    }
}
