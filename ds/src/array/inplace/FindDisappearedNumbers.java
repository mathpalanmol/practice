package array.inplace;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array (LeetCode #448)
 *
 * <p>Given {@code n} integers where {@code nums[i]} is in {@code [1, n]}, return all integers
 * in {@code [1, n]} that do not appear. Solve in O(n) time and O(1) extra space (output aside).
 *
 * <p>Constraints: {@code 1 <= n <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>For each {@code i}, {@code idx = abs(nums[i]) - 1}; if {@code nums[idx] &gt; 0}, negate {@code nums[idx]} (mark seen).</li>
 *   <li>Second pass: indices with positive {@code nums[i]} → missing number {@code i + 1}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [4,3,2,7,8,2,3,1]
 * Step:   indices 4,5 never marked negative
 * Output: [5, 6]
 * </pre>
 */
public class FindDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx]; // mark index idx as "seen"
            }
        }
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                out.add(i + 1);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Missing: " + findDisappearedNumbers(nums));
    }
}
