package array.binarysearch;

/**
 * Find Peak Element (LeetCode #162)
 *
 * <p>A peak element is strictly greater than its neighbors. Given {@code nums}, return the
 * index of any peak. For edges, treat missing neighbor as -∞. You may assume {@code nums[-1]}
 * and {@code nums[n]} are -∞.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 1000}; {@code O(log n)} required.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code lo = 0}, {@code hi = n - 1}.</li>
 *   <li>While {@code lo &lt; hi}: {@code mid = lo + (hi-lo)/2}.</li>
 *   <li>If {@code nums[mid] &lt; nums[mid + 1]}, {@code lo = mid + 1} (ascending → peak on right).</li>
 *   <li>Else {@code hi = mid} (peak at mid or left).</li>
 *   <li>Return {@code lo}.</li>
 * </ol>
 * <p>Time: O(log n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [1, 2, 3, 1]
 * Step:   mid=1, nums[1]&lt;nums[2] → search right; lo=hi=2
 * Output: 2
 * </pre>
 */
public class PeakElement {

    public static int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1; // ascending slope → peak on right
            } else {
                hi = mid; // mid is peak or peak on left
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Peak index: " + findPeakElement(nums));
    }
}
