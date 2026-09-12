package array.greedy;

/**
 * Jump Game (LeetCode #55)
 *
 * <p>Given non-negative {@code nums[i]} = max jump length from index {@code i}, return whether
 * you can reach the last index starting at 0.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^4}; {@code 0 <= nums[i] <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code farthest = 0}.</li>
 *   <li>For each index {@code i}: if {@code i &gt; farthest}, return false.</li>
 *   <li>{@code farthest = max(farthest, i + nums[i])}.</li>
 *   <li>Return true after loop.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [2, 3, 1, 1, 4]
 * Step:   farthest reaches index 4
 * Output: true
 * </pre>
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false; // cannot reach this index
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can reach end: " + canJump(nums));
    }
}
