package array.greedy;

/**
 * Jump Game II (LeetCode #45)
 *
 * <p>Same jump rules as Jump Game I; return the minimum number of jumps to reach the last index.
 * Guaranteed reachable.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^4}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>If {@code n &lt;= 1}, return 0. Set {@code jumps = 0}, {@code curEnd = 0}, {@code nextEnd = 0}.</li>
 *   <li>For {@code i = 0 .. n-2}: {@code nextEnd = max(nextEnd, i + nums[i])}.</li>
 *   <li>When {@code i == curEnd}, increment {@code jumps}, set {@code curEnd = nextEnd} (finish current jump layer).</li>
 *   <li>Return {@code jumps}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [2, 3, 1, 1, 4]
 * Step:   jump 1 reaches index 1; jump 2 reaches index 4
 * Output: 2
 * </pre>
 */
public class JumpGameII {

    public static int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int curEnd = 0;
        int nextEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextEnd = Math.max(nextEnd, i + nums[i]);
            if (i == curEnd) { // finished current jump layer
                jumps++;
                curEnd = nextEnd;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Min jumps: " + jump(nums));
    }
}
