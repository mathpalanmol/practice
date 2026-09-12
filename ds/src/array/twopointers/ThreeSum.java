package array.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum (LeetCode #15)
 *
 * <p>Given integer array {@code nums}, find all unique triplets {@code [nums[i], nums[j], nums[k]]}
 * such that {@code i != j != k} and the three sum to zero. Return lists in any order.
 *
 * <p>Constraints: {@code 3 <= nums.length <= 3000}; values in {@code [-10^5, 10^5]}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code Arrays.sort(nums)}.</li>
 *   <li>For {@code i = 0 .. n-3}: skip if {@code i &gt; 0 &amp;&amp; nums[i] == nums[i-1]}.</li>
 *   <li>Set {@code lo = i + 1}, {@code hi = n - 1}; while {@code lo &lt; hi}, {@code sum = nums[i] + nums[lo] + nums[hi]}.</li>
 *   <li>If {@code sum == 0}, append triplet, then advance {@code lo} and {@code hi} skipping equal {@code nums[lo]} / {@code nums[hi]}.</li>
 *   <li>If {@code sum &lt; 0}, {@code lo++}; else {@code hi--}.</li>
 * </ol>
 * <p>Time: O(n²), Space: O(1) excluding output
 *
 * <pre>
 * Input:  nums = [-1, 0, 1, 2, -1, -4]
 * Step:   sorted; i=-1 with lo,hi → (-1,0,1) and (-1,2,-1)
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 * </pre>
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // same anchor → duplicate triplets
            }
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + threeSum(nums));
    }
}
