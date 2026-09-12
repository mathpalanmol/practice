package array.twopointers;

import java.util.Arrays;

/**
 * Two Sum II — Input Array Is Sorted (LeetCode #167)
 *
 * <p>Given a 1-indexed sorted array {@code numbers} and {@code target}, return the two indices
 * (1-based) such that the numbers add up to {@code target}. Exactly one solution exists;
 * you may not use the same element twice.
 *
 * <p>Constraints: {@code 2 <= numbers.length <= 3 * 10^4}; sorted ascending.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code lo = 0}, {@code hi = n - 1}.</li>
 *   <li>While {@code lo &lt; hi}: {@code sum = numbers[lo] + numbers[hi]}.</li>
 *   <li>If {@code sum == target}, return {@code [lo + 1, hi + 1]} (1-based).</li>
 *   <li>If {@code sum &lt; target}, {@code lo++}; else {@code hi--}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  numbers = [2, 7, 11, 15], target = 9
 * Step:   lo+hi = 2+15 &gt; 9 → hi--; then 2+7 = 9
 * Output: [1, 2]
 * </pre>
 */
public class TwoSumII {

    public static int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if (sum == target) {
                return new int[] {lo + 1, hi + 1};
            }
            if (sum < target) {
                lo++; // sorted → larger sum needs bigger left value
            } else {
                hi--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println("Indices (1-based): " + Arrays.toString(twoSum(nums, 9)));
    }
}
