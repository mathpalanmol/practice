package array.binarysearch;

/**
 * Search a 2D Matrix (LeetCode #74)
 *
 * <p>Given {@code m × n} matrix with rows sorted left-to-right and first element of each row
 * greater than last of previous row, determine if {@code target} exists.
 *
 * <p>Constraints: {@code m, n >= 1}; {@code -10^4 <= values <= 10^4}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Treat matrix as sorted array of length {@code m * n}; {@code lo = 0}, {@code hi = m*n - 1}.</li>
 *   <li>While {@code lo &lt;= hi}: {@code mid = lo + (hi-lo)/2}; {@code val = matrix[mid/n][mid%n]}.</li>
 *   <li>If {@code val == target}, return true; if {@code val &lt; target}, {@code lo = mid + 1}; else {@code hi = mid - 1}.</li>
 *   <li>Return false.</li>
 * </ol>
 * <p>Time: O(log(mn)), Space: O(1)
 *
 * <pre>
 * Input:  matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Step:   flat index 1 → matrix[0][1] = 3
 * Output: true
 * </pre>
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            }
            if (val < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Contains 3: " + searchMatrix(m, 3));
    }
}
