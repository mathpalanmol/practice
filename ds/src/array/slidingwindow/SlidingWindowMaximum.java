package array.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Sliding Window Maximum (LeetCode #239)
 *
 * <p>Given integer array {@code nums} and window size {@code k}, return an array of the
 * maximum value in each sliding window of size {@code k}.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}; {@code 1 <= k <= nums.length}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Monotonic deque {@code dq} of indices (decreasing {@code nums[dq]}).</li>
 *   <li>For each index {@code i}: poll front while {@code dq.peekFirst() &lt;= i - k} (out of window).</li>
 *   <li>While back index has value ≤ {@code nums[i]}, {@code pollLast()}.</li>
 *   <li>{@code addLast(i)}; if {@code i >= k - 1}, {@code out[i - k + 1] = nums[dq.peekFirst()]}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(k)
 *
 * <pre>
 * Input:  nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
 * Step:   deque front tracks max of each width-k window
 * Output: [3, 3, 5, 5, 6, 7]
 * </pre>
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] out = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst(); // left edge left the window
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast(); // smaller values never become max before i exits
            }
            dq.addLast(i);
            if (i >= k - 1) {
                out[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("Window maxes: " + Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
