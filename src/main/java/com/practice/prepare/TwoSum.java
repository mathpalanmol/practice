package com.practice.prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Returns indices of the two numbers that add up to target.
     * Assumes exactly one valid solution exists.
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
