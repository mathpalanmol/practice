package array.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum (LeetCode #1)
 *
 * <p>Given an integer array {@code nums} and an integer {@code target}, return indices of the
 * two numbers such that they add up to {@code target}. You may assume exactly one solution
 * and you may not use the same element twice.
 *
 * <p>Constraints: {@code 2 <= nums.length <= 10^4}; each answer has exactly one valid pair.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Create empty hash map {@code idx}: value → index seen so far.</li>
 *   <li>For each index {@code i}, compute {@code need = target - nums[i]}.</li>
 *   <li>If {@code idx} contains {@code need}, return {@code [idx.get(need), i]}.</li>
 *   <li>Otherwise {@code idx.put(nums[i], i)} (store after lookup so the same index is not reused).</li>
 *   <li>If the loop ends, return empty (no pair).</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  nums = [2, 7, 11, 15], target = 9
 * Step:   i=0 → map {2:0}; i=1, need=2 → map has 2 at index 0
 * Output: [0, 1]
 * </pre>
 */
public class TwoSum {

    /**
     * Returns the two indices whose values sum to {@code target}, or empty if none.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (idx.containsKey(need)) {
                return new int[] {idx.get(need), i};
            }
            idx.put(nums[i], i); // record after lookup — avoids using same index twice
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println("Indices: " + Arrays.toString(twoSum(nums, 9)));
    }
}
