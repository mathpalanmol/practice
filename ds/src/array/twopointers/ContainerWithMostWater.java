package array.twopointers;

/**
 * Container With Most Water (LeetCode #11)
 *
 * <p>Given {@code n} non-negative integers {@code height[i]} as vertical lines, find two lines
 * that together with the x-axis form a container holding the most water. Return the maximum
 * area (not the pair of indices).
 *
 * <p>Constraints: {@code n >= 2}; {@code 0 <= height[i] <= 10^4}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set {@code left = 0}, {@code right = n - 1}, {@code best = 0}.</li>
 *   <li>While {@code left &lt; right}: {@code h = min(height[left], height[right])};
 *       {@code best = max(best, h * (right - left))}.</li>
 *   <li>If {@code height[left] &lt; height[right]}, {@code left++}; else {@code right--} (move the shorter line inward).</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(1)
 *
 * <pre>
 * Input:  height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * Step:   best area 49 at lines 1 and 8: min(8,7) × 7
 * Output: 49
 * </pre>
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int best = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            best = Math.max(best, h * (right - left));
            if (height[left] < height[right]) {
                left++; // shorter side limits height — try to find a taller left line
            } else {
                right--;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area: " + maxArea(h));
    }
}
