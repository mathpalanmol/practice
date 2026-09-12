package array.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Largest Rectangle in Histogram (LeetCode #84)
 *
 * <p>Given array {@code heights} of bar heights (width 1), return area of the largest
 * rectangle in the histogram.
 *
 * <p>Constraints: {@code 1 <= heights.length <= 10^5}; {@code 0 <= heights[i] <= 10^4}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Stack {@code stack} of indices (increasing heights).</li>
 *   <li>For {@code i = 0 .. n} (use {@code h = 0} sentinel at {@code i==n}): while stack non-empty and {@code h &lt; heights[stack.peek()]},
 *       pop index, {@code width = stack empty ? i : i - stack.peek() - 1}, update {@code best = max(best, height*width)}.</li>
 *   <li>Push {@code i} onto stack.</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(n), Space: O(n)
 *
 * <pre>
 * Input:  heights = [2, 1, 5, 6, 2, 3]
 * Step:   max rectangle height 5 width 2 → area 10
 * Output: 10
 * </pre>
 */
public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i]; // sentinel forces pop all
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                best = Math.max(best, height * width);
            }
            stack.push(i);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] h = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle: " + largestRectangleArea(h));
    }
}
