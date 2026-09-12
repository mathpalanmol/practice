package array.twopointers;

/**
 * Trapping Rain Water (LeetCode #42)
 *
 * <p>Given {@code n} non-negative bars {@code height}, compute how much rain water can be
 * trapped after raining (water between bars, not on top).
 *
 * <p>Constraints: {@code n >= 1}; {@code 0 <= height[i] <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code left = 0}, {@code right = n - 1}, {@code leftMax = 0}, {@code rightMax = 0}, {@code water = 0}.</li>
 *   <li>While {@code left &lt; right}: if {@code height[left] &lt;= height[right]}, update {@code leftMax = max(leftMax, height[left])},
 *       add {@code leftMax - height[left]} to {@code water}, {@code left++}.</li>
 *   <li>Else update {@code rightMax = max(rightMax, height[right])}, add {@code rightMax - height[right]}, {@code right--}.</li>
 *   <li>Return {@code water} (process the shorter side — that side’s max bounds trapped water).</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * Output: 6
 * </pre>
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left]; // bounded by leftMax on this side
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(h));
    }
}
