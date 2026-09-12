package array.matrix;

/**
 * Search a 2D Matrix II (LeetCode #240)
 *
 * <p>Given {@code m × n} matrix where each row and column is sorted ascending, determine if
 * {@code target} exists.
 *
 * <p>Constraints: {@code m, n >= 1}; {@code -10^9 <= values <= 10^9}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Start {@code r = 0}, {@code c = cols - 1} (top-right).</li>
 *   <li>While {@code r &lt; rows &amp;&amp; c &gt;= 0}: if {@code matrix[r][c] == target}, return true.</li>
 *   <li>If {@code matrix[r][c] &gt; target}, {@code c--}; else {@code r++}.</li>
 *   <li>Return false.</li>
 * </ol>
 * <p>Time: O(m+n), Space: O(1)
 *
 * <pre>
 * Input:  matrix = [[1,4,7,11],[2,5,8,12],[3,6,9,16]], target = 5
 * Step:   11→7→5 found at (1,1)
 * Output: true
 * </pre>
 */
public class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}};
        System.out.println("Contains 5: " + searchMatrix(m, 5));
    }
}
