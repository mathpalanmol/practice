package array.hard;

/**
 * Median of Two Sorted Arrays (LeetCode #4)
 *
 * <p>Given sorted arrays {@code nums1} and {@code nums2} of size {@code m} and {@code n},
 * return the median of the merged sorted array in O(log(m+n)).
 *
 * <p>Constraints: {@code m, n >= 0}; at least one non-empty; values fit in int.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>If {@code nums1.length &gt; nums2.length}, swap so {@code nums1} is shorter ({@code m ≤ n}).</li>
 *   <li>Binary search {@code i} in {@code [0, m]}; {@code j = (m+n+1)/2 - i} splits left/right halves.</li>
 *   <li>{@code maxLeft1, minRight1, maxLeft2, minRight2} from partition edges (use ±∞ at boundaries).</li>
 *   <li>If {@code maxLeft1 &lt;= minRight2 &amp;&amp; maxLeft2 &lt;= minRight1}: odd total → {@code max(maxLeft1,maxLeft2)};
 *       even → average of {@code max(maxLeft1,maxLeft2)} and {@code min(minRight1,minRight2)}.</li>
 *   <li>Else adjust {@code lo/hi}: if {@code maxLeft1 &gt; minRight2}, {@code hi = i-1}; else {@code lo = i+1}.</li>
 * </ol>
 * <p>Time: O(log(min(m,n))), Space: O(1)
 *
 * <pre>
 * Input:  nums1 = [1, 3], nums2 = [2]
 * Step:   partition i=1,j=0 → left [1], right [2] → median 2
 * Output: 2.0
 * </pre>
 */
public class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // binary search smaller array
        }
        int m = nums1.length, n = nums2.length;
        int lo = 0, hi = m;
        while (lo <= hi) {
            int i = (lo + hi) / 2;
            int j = (m + n + 1) / 2 - i;
            int maxLeft1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = j == n ? Integer.MAX_VALUE : nums2[j];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                }
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }
            if (maxLeft1 > minRight2) {
                hi = i - 1; // take fewer from nums1 left
            } else {
                lo = i + 1;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println("Median: " + findMedianSortedArrays(a, b));
    }
}
