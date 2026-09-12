package array.binarysearch;

/**
 * Search in Rotated Sorted Array (LeetCode #33)
 *
 * <p>Given rotated sorted array {@code nums} (distinct) and {@code target}, return index of
 * {@code target} or {@code -1}. Array was sorted ascending then rotated at unknown pivot.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 5000}; all values distinct.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code lo = 0}, {@code hi = n - 1}; while {@code lo &lt;= hi}, {@code mid = lo + (hi-lo)/2}.</li>
 *   <li>If {@code nums[mid] == target}, return mid.</li>
 *   <li>If {@code nums[lo] &lt;= nums[mid]} (left half sorted): if {@code nums[lo] &lt;= target &lt; nums[mid]},
 *       {@code hi = mid - 1}; else {@code lo = mid + 1}.</li>
 *   <li>Else (right half sorted): if {@code nums[mid] &lt; target &lt;= nums[hi]},
 *       {@code lo = mid + 1}; else {@code hi = mid - 1}.</li>
 *   <li>Return -1.</li>
 * </ol>
 * <p>Time: O(log n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [4, 5, 6, 7, 0, 1, 2], target = 0
 * Step:   right half sorted contains 0 → lo moves to index 4
 * Output: 4
 * </pre>
 */
public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) { // left half sorted
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // right half sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Index of 0: " + search(nums, 0));
    }
}
