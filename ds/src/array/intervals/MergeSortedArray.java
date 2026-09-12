package array.intervals;

import java.util.Arrays;

/**
 * Merge Sorted Array (LeetCode #88)
 *
 * <p>Merge {@code nums2} into {@code nums1} as one sorted array. {@code nums1} has length
 * {@code m + n} where first {@code m} elements are valid; {@code nums2} has length {@code n}.
 * Modify {@code nums1} in-place.
 *
 * <p>Constraints: {@code m, n >= 0}; both sorted non-decreasing.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code i = m-1}, {@code j = n-1}, {@code k = m+n-1}.</li>
 *   <li>While {@code j &gt;= 0}: if {@code i &gt;= 0 &amp;&amp; nums1[i] &gt; nums2[j]}, {@code nums1[k--]=nums1[i--]};
 *       else {@code nums1[k--]=nums2[j--]}.</li>
 *   <li>Remaining {@code nums1} prefix already in place when {@code j} exhausts.</li>
 * </ol>
 * <p>Time: O(m+n), Space: O(1)
 *
 * <pre>
 * Input:  nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Step:   fill from back: 6,5,3,2,2,1
 * Output: nums1 = [1,2,2,3,5,6]
 * </pre>
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--]; // nums2 exhausted or nums2[j] larger
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        System.out.println("Before: " + Arrays.toString(a));
        merge(a, 3, b, 3);
        System.out.println("After:  " + Arrays.toString(a));
    }
}
