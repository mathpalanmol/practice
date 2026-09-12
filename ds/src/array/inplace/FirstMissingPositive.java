package array.inplace;

/**
 * First Missing Positive (LeetCode #41)
 *
 * <p>Given unsorted array {@code nums}, return the smallest missing positive integer.
 * Must run in O(n) time and O(1) auxiliary space.
 *
 * <p>Constraints: {@code 1 <= nums.length <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>For each {@code i}, while {@code nums[i]} in {@code [1,n]} and {@code nums[nums[i]-1] != nums[i]},
 *       swap {@code nums[i]} with {@code nums[nums[i]-1]}.</li>
 *   <li>Scan: first {@code i} with {@code nums[i] != i + 1} → return {@code i + 1}.</li>
 *   <li>If all match, return {@code n + 1}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  nums = [3, 4, -1, 1]
 * Step:   after swaps [1, -1, 3, 4]; index 1 has -1 ≠ 2
 * Output: 2
 * </pre>
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp; // nums[i] belongs at index j
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1; // 1..n all present
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + firstMissingPositive(nums));
    }
}
