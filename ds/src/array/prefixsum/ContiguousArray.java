package array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * Contiguous Array (LeetCode #525)
 *
 * <p>Given binary array {@code nums} (0s and 1s only), return the maximum length of a
 * contiguous subarray with equal number of 0 and 1.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Map {@code first}: prefix sum → earliest index; seed {@code first.put(0, -1)}.</li>
 *   <li>Scan with {@code sum}: add {@code +1} if {@code nums[i]==1}, else {@code -1}.</li>
 *   <li>If {@code first} contains {@code sum}, {@code best = max(best, i - first.get(sum))}.</li>
 *   <li>Else {@code first.put(sum, i)} (only first occurrence matters).</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  nums = [0, 1, 0]
 * Step:   at i=1 prefix sum 0 again → length 1-(-1)=2
 * Output: 2
 * </pre>
 */
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>();
        first.put(0, -1);
        int sum = 0, best = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (first.containsKey(sum)) {
                best = Math.max(best, i - first.get(sum));
            } else {
                first.put(sum, i); // only earliest index matters for max length
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println("Max equal 0/1 length: " + findMaxLength(nums));
    }
}
