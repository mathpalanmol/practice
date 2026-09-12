package array.inplace;

/**
 * Find the Duplicate Number (LeetCode #287)
 *
 * <p>Given array {@code nums} of length {@code n+1} with values in {@code [1, n]} inclusive,
 * exactly one duplicate exists (may repeat more than once). Find it without modifying the
 * array and using O(1) extra space.
 *
 * <p>Constraints: {@code 1 <= n <= 10^5}; one duplicate, multiple copies allowed.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Interpret {@code i → nums[i]} as linked list; duplicate value creates a cycle.</li>
 *   <li>Phase 1: {@code slow = nums[0]}, {@code fast = nums[0]}; repeat {@code slow = nums[slow]},
 *       {@code fast = nums[nums[fast]]} until {@code slow == fast}.</li>
 *   <li>Phase 2: {@code slow = nums[0]}; while {@code slow != fast}, advance both one step.</li>
 *   <li>Return {@code slow} (cycle entry = duplicate).</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [1, 3, 4, 2, 2]
 * Step:   cycle enters at index 2 → value 2
 * Output: 2
 * </pre>
 */
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]]; // fast moves two edges
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast]; // same speed from head and meeting point
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println("Duplicate: " + findDuplicate(nums));
    }
}
