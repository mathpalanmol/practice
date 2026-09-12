package array.binarysearch;

import java.util.Arrays;

/**
 * Find First and Last Position of Element in Sorted Array (LeetCode #34)
 *
 * <p>Given sorted array {@code nums} and {@code target}, return start and end indices of
 * {@code target} in the array. If not found, return {@code [-1, -1]}.
 *
 * <p>Constraints: {@code 0 <= nums.length <= 10^5}; {@code -10^9 <= nums[i], target <= 10^9}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Define {@code lowerBound(nums, target)}: set {@code lo = 0}, {@code hi = nums.length};
 *       while {@code lo &lt; hi}, pick {@code mid = lo + (hi - lo) / 2}; if {@code nums[mid] &lt; target}
 *       then {@code lo = mid + 1}, else {@code hi = mid}; return {@code lo} (first index with
 *       {@code nums[i] >= target}).</li>
 *   <li><strong>First position:</strong> {@code lo = lowerBound(nums, target)}; if {@code lo == length}
 *       or {@code nums[lo] != target}, return {@code [-1, -1]}.</li>
 *   <li><strong>Last position:</strong> {@code hi = lowerBound(nums, target + 1) - 1} — same lower bound
 *       on the first index where value is at least {@code target + 1}, minus one gives the last {@code target}.</li>
 *   <li>Return {@code [lo, hi]}.</li>
 * </ol>
 * <p>Time: O(log n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [5, 7, 7, 8, 8, 10], target = 8
 * Step:   lowerBound(8) → index 3 (first 8); lowerBound(9) → 5, so last = 5 - 1 = 4
 * Output: [3, 4]
 * </pre>
 */
public class FindFirstLastPosition {

    public static int[] searchRange(int[] nums, int target) {
        int lo = lowerBound(nums, target);
        if (lo == nums.length || nums[lo] != target) {
            return new int[] {-1, -1};
        }
        int hi = lowerBound(nums, target + 1) - 1; // last position of target
        return new int[] {lo, hi};
    }

    /**
     * Lower bound: smallest {@code lo} in {@code [0, nums.length)} with {@code nums[lo] >= target}.
     * Loop invariant: answer in {@code [lo, hi)}; shrink with {@code nums[mid] &lt; target ? lo=mid+1 : hi=mid}.
     */
    private static int lowerBound(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println("Range of 8: " + Arrays.toString(searchRange(nums, 8)));
    }
}
