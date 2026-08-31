package com.practice.prepare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 3Sum (LeetCode #15)
 *
 * <p>Given an integer array {@code nums}, return all unique triplets
 * {@code [nums[i], nums[j], nums[k]]} such that {@code i != j}, {@code i != k},
 * {@code j != k}, and {@code nums[i] + nums[j] + nums[k] == 0}.
 *
 * <p>The solution set must not contain duplicate triplets.
 *
 * <p>Examples:
 * <pre>
 * Input:  nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * Input:  nums = [0, 1, 1]
 * Output: []
 *
 * Input:  nums = [0, 0, 0]
 * Output: [[0, 0, 0]]
 * </pre>
 *
 * <p>Constraints:
 * <ul>
 *   <li>{@code 3 <= nums.length <= 3000}</li>
 *   <li>{@code -10^5 <= nums[i] <= 10^5}</li>
 * </ul>
 *
 * <p><b>Solution (two pointers — {@link #threeSum(int[])}):</b>
 * <ol>
 *   <li>Sort the array so we can use two pointers and skip duplicates.</li>
 *   <li>Fix {@code nums[i]} as the first element of the triplet.</li>
 *   <li>Use {@code left = i + 1} and {@code right = end} to find pairs summing to {@code -nums[i]}.</li>
 *   <li>If sum {@code == 0}, record the triplet and skip duplicate {@code left}/{@code right} values.</li>
 *   <li>If sum {@code < 0}, move {@code left++}; if sum {@code > 0}, move {@code right--}.</li>
 *   <li>Skip duplicate {@code i} with {@code nums[i] == nums[i - 1]}.</li>
 * </ol>
 * Time: O(n²), Space: O(1) excluding output.
 *
 * <p><b>Solution (two pointers + HashSet — {@link #threeSumWithHashSet(int[])}):</b>
 * Same two-pointer scan as above, but store triplets in a {@code HashSet} to avoid duplicates
 * instead of skipping duplicate pointers. Results are sorted before return.
 * Time: O(n²), Space: O(n).
 */
public class ThreeSum {

    /**
     * Returns all unique triplets that sum to zero.
     *
     * <p>Sort → fix {@code nums[i]} → two pointers on the remaining subarray.
     * Duplicates are avoided by skipping repeated {@code i}, {@code left}, and {@code right}.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * Returns all unique triplets that sum to zero.
     *
     * <p>Sort → fix {@code nums[i]} → two pointers. Uses a {@code HashSet} to dedupe triplets
     * instead of skipping duplicate pointer values; output is sorted for consistent order.
     */
    public List<List<Integer>> threeSumWithHashSet(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        List<List<Integer>> sorted = new ArrayList<>(result);
        sorted.sort(Comparator
                .comparingInt((List<Integer> triplet) -> triplet.get(0))
                .thenComparingInt(triplet -> triplet.get(1))
                .thenComparingInt(triplet -> triplet.get(2)));
        return sorted;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(solver.threeSum(nums)); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(solver.threeSumWithHashSet(nums));
    }
}
