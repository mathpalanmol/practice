package array.binarysearch;

/**
 * Find Minimum in Rotated Sorted Array (LeetCode #153)
 *
 * <p>Given rotated sorted array {@code nums} with distinct values, return the minimum element.
 * Array was sorted ascending with no duplicates, then rotated 1..n times.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 5000}; distinct values.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code lo = 0}, {@code hi = n - 1}.</li>
 *   <li>While {@code lo &lt; hi}: {@code mid = lo + (hi-lo)/2}.</li>
 *   <li>If {@code nums[mid] &gt; nums[hi]}, minimum is right of mid → {@code lo = mid + 1}.</li>
 *   <li>Else minimum is at mid or left → {@code hi = mid}.</li>
 *   <li>Return {@code nums[lo]}.</li>
 * </ol>
 * <p>Time: O(log n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [3, 4, 5, 1, 2]
 * Step:   nums[mid]&gt;nums[hi] → lo moves to 3; nums[3]=1 is min
 * Output: 1
 * </pre>
 */
public class FindMinRotatedSortedArray {

    public static int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1; // pivot/min to the right of mid
            } else {
                hi = mid; // mid could be min
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println("Minimum: " + findMin(nums));
    }
}
