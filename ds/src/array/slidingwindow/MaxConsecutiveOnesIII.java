package array.slidingwindow;

/**
 * Max Consecutive Ones III (LeetCode #1004)
 *
 * <p>Given binary array {@code nums} and integer {@code k}, return the maximum number of
 * consecutive 1's in the array if you can flip at most {@code k} 0's to 1's.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}; {@code nums[i]} is 0 or 1; {@code 0 <= k <= nums.length}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>{@code left = 0}, {@code zeros = 0}, {@code best = 0}.</li>
 *   <li>Expand {@code right}: if {@code nums[right]==0}, {@code zeros++}.</li>
 *   <li>While {@code zeros &gt; k}, if {@code nums[left]==0} decrement {@code zeros}; {@code left++}.</li>
 *   <li>{@code best = max(best, right - left + 1)}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Step:   max valid window length 6 with at most 2 zeros flipped
 * Output: 6
 * </pre>
 */
public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, best = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println("Longest ones with k=2: " + longestOnes(nums, 2));
    }
}
