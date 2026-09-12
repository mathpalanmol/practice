package array.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence (LeetCode #128)
 *
 * <p>Given an unsorted array {@code nums}, return the length of the longest consecutive
 * elements sequence. The sequence need not be contiguous in the array; run in {@code O(n)}.
 *
 * <p>Constraints: {@code 0 <= nums.length <= 10^5}; values may repeat (set dedupes).
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Insert every value from {@code nums} into hash set {@code set}.</li>
 *   <li>For each {@code x} in {@code set}, skip if {@code set.contains(x - 1)} (not a sequence start).</li>
 *   <li>From start {@code x}, set {@code len = 1} and while {@code set.contains(x + len)}, increment {@code len}.</li>
 *   <li>Update {@code best = max(best, len)}.</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  nums = [100, 4, 200, 1, 3, 2]
 * Step:   start at 1 (0 absent); chain 1→2→3→4 → len 4
 * Output: 4
 * </pre>
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int best = 0;
        for (int x : set) {
            if (set.contains(x - 1)) {
                continue; // not the start of a sequence
            }
            int len = 1;
            while (set.contains(x + len)) {
                len++;
            }
            best = Math.max(best, len);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive: " + longestConsecutive(nums));
    }
}
