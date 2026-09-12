package array.hard;

/**
 * Maximal Rectangle (LeetCode #85)
 *
 * <p>Given binary matrix of {@code '0'} and {@code '1'}, return area of the largest rectangle
 * containing only {@code '1'}.
 *
 * <p>Constraints: {@code rows, cols <= 200}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Array {@code heights[c]} = stacked height of consecutive {@code '1'}s in column {@code c}.</li>
 *   <li>For each row: update {@code heights[c]} (+1 if {@code '1'}, else 0).</li>
 *   <li>{@code best = max(best, LargestRectangleHistogram.largestRectangleArea(heights))}.</li>
 *   <li>Return {@code best}.</li>
 * </ol>
 * <p>Time: O(rows × cols), Space: O(cols)
 *
 * <pre>
 * Input:  matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Step:   row 3 histogram max area 6
 * Output: 6
 * </pre>
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int best = 0;
        for (char[] row : matrix) {
            for (int c = 0; c < cols; c++) {
                heights[c] = row[c] == '1' ? heights[c] + 1 : 0;
            }
            best = Math.max(best, LargestRectangleHistogram.largestRectangleArea(heights));
        }
        return best;
    }

    public static void main(String[] args) {
        char[][] m = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Max rectangle area: " + maximalRectangle(m));
    }
}
