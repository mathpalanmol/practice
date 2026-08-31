package com.practice.prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum (LeetCode #1)
 *
 * <p>Given an array of integers {@code nums} and an integer {@code target},
 * return the indices of the two numbers such that they add up to {@code target}.
 *
 * <p>You may assume that each input has exactly one solution, and you may not
 * use the same element twice. You can return the answer in any order.
 *
 * <p>Examples:
 * <pre>
 * Input:  nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]   // nums[0] + nums[1] = 2 + 7 = 9
 *
 * Input:  nums = [3, 2, 4], target = 6
 * Output: [1, 2]
 *
 * Input:  nums = [3, 3], target = 6
 * Output: [0, 1]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 2 <= nums.length <= 10^4}</li>
 *   <li>{@code -10^9 <= nums[i], target <= 10^9}</li>
 *   <li>Exactly one valid answer exists</li>
 * </ul>
 */
public class TwoSum {

    /**
     * Returns indices of the two numbers that add up to target.
     * Approach: HashMap — for each element, check if its complement was seen.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check before put: nums[i] is not in the map yet, so we only
            // match against earlier indices — no same-index guard needed.
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(solver.twoSum(nums, target))); // [0, 1]
    }
}
