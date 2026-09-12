package array.matrix;

import java.util.Arrays;

/**
 * Set Matrix Zeroes (LeetCode #73)
 *
 * <p>Given {@code m × n} matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 *
 * <p>Constraints: {@code m, n >= 1}; follow-up asks for O(1) extra space.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Scan row 0 → {@code row0} if any zero; scan col 0 → {@code col0}.</li>
 *   <li>For {@code i,j &gt;= 1}: if {@code matrix[i][j]==0}, set {@code matrix[i][0]=0} and {@code matrix[0][j]=0}.</li>
 *   <li>For {@code i,j &gt;= 1}: if {@code matrix[i][0]==0 || matrix[0][j]==0}, zero {@code matrix[i][j]}.</li>
 *   <li>If {@code row0}, zero row 0; if {@code col0}, zero column 0.</li>
 * </ol>
 * <p>Time: O(mn), Space: O(1)
 *
 * <pre>
 * Input:  matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Step:   center 0 marks row 1 and col 1
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * </pre>
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false, col0 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // mark row i
                    matrix[0][j] = 0; // mark column j
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Before: " + Arrays.deepToString(m));
        setZeroes(m);
        System.out.println("After:  " + Arrays.deepToString(m));
    }
}
