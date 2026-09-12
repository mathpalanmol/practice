package array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters (LeetCode #3)
 *
 * <p>Given string {@code s}, find the length of the longest substring without repeating
 * characters.
 *
 * <p>Constraints: {@code 0 <= s.length <= 5 * 10^4}; ASCII characters.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Map {@code last}: character → last index; {@code left = 0}, {@code best = 0}.</li>
 *   <li>For {@code right = 0 .. len-1}, {@code c = s.charAt(right)}.</li>
 *   <li>If {@code last} has {@code c} and {@code last.get(c) >= left}, set {@code left = last.get(c) + 1}.</li>
 *   <li>{@code last.put(c, right)}; {@code best = max(best, right - left + 1)}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(min(n, alphabet))
 *
 * <pre>
 * Input:  s = "abcabcbb"
 * Step:   window "abc" length 3; repeat 'a' shrinks left
 * Output: 3
 * </pre>
 */
public class LongestSubstringNoRepeat {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> last = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (last.containsKey(c) && last.get(c) >= left) {
                left = last.get(c) + 1; // shrink past previous occurrence
            }
            last.put(c, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest unique substring: " + lengthOfLongestSubstring(s));
    }
}
