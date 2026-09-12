package array.greedy;

import java.util.Arrays;

/**
 * Next Permutation (LeetCode #31)
 *
 * <p>Given {@code nums}, rearrange to the next lexicographically greater permutation of its
 * integers. If none (already largest), rearrange to smallest (ascending). Modify in-place.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 100}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>From end, find largest {@code i} with {@code nums[i] &lt; nums[i+1]} (pivot).</li>
 *   <li>If {@code i &gt;= 0}: from end, find {@code j} with {@code nums[j] &gt; nums[i]}; swap {@code i,j}.</li>
 *   <li>Reverse {@code nums[i+1 .. n-1]} (smallest suffix after pivot).</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [1, 2, 3]
 * Step:   pivot i=1; swap 2 with 3 → [1,3,2]
 * Output: [1, 3, 2]
 * </pre>
 */
public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--; // find pivot
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1); // smallest suffix after pivot
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void reverse(int[] a, int lo, int hi) {
        while (lo < hi) {
            swap(a, lo++, hi--);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println("Before: " + Arrays.toString(a));
        nextPermutation(a);
        System.out.println("After:  " + Arrays.toString(a));
    }
}
