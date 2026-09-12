package array.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate (LeetCode #217)
 *
 * <p>Given an integer array {@code nums}, return {@code true} if any value appears at least
 * twice, otherwise {@code false}.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}; values fit in 32-bit int.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Create empty hash set {@code seen}.</li>
 *   <li>For each {@code x} in {@code nums}, call {@code seen.add(x)}.</li>
 *   <li>If {@code add} returns {@code false}, {@code x} was already in {@code seen} → return {@code true}.</li>
 *   <li>After the loop, return {@code false}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  nums = [1, 2, 3, 1]
 * Step:   1,2,3 added; second 1 → add fails
 * Output: true
 * </pre>
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (!seen.add(x)) { // add fails → we have seen x before
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Has duplicate: " + containsDuplicate(nums));
    }
}
