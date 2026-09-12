package array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix (LeetCode #54)
 *
 * <p>Given {@code m × n} matrix, return all elements in clockwise spiral order.
 *
 * <p>Constraints: {@code m, n >= 1}; {@code m * n <= 10^5}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Set bounds {@code top, bottom, left, right}.</li>
 *   <li>While {@code top &lt;= bottom &amp;&amp; left &lt;= right}: append top row left→right, {@code top++}.</li>
 *   <li>Append right column top→bottom, {@code right--}.</li>
 *   <li>If {@code top &lt;= bottom}, append bottom row right→left, {@code bottom--}.</li>
 *   <li>If {@code left &lt;= right}, append left column bottom→top, {@code left++}.</li>
 * </ol>
 * <p>Time: O(mn), Space: O(1) excluding output
 *
 * <pre>
 * Input:  matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Step:   layer 1→2→3→6→9→8→7→4, then 5
 * Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * </pre>
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new ArrayList<>();
        if (matrix.length == 0) {
            return out;
        }
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                out.add(matrix[top][c]);
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                out.add(matrix[r][right]);
            }
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    out.add(matrix[bottom][c]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    out.add(matrix[r][left]);
                }
                left++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Spiral: " + spiralOrder(m));
    }
}
