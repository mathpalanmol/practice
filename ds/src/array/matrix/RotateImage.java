package array.matrix;

import java.util.Arrays;

/**
 * Rotate Image (LeetCode #48)
 *
 * <p>Given {@code n × n} matrix, rotate the image 90 degrees clockwise in-place.
 *
 * <p>Constraints: {@code n == matrix.length == matrix[i].length}; {@code 1 <= n <= 20}.
 *
 * <h2>Algorithm</h2>
 * <ol>
 *   <li>Transpose: for {@code i = 0 .. n-1}, for {@code j = i+1 .. n-1}, swap {@code matrix[i][j]} and {@code matrix[j][i]}.</li>
 *   <li>For each row {@code i}, reverse columns {@code [0 .. n-1]} with two pointers {@code lo, hi}.</li>
 * </ol>
 * <p>Time: O(n²), Space: O(1)
 *
 * <pre>
 * Input:  matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Step:   transpose then reverse rows
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * </pre>
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = n - 1;
            while (lo < hi) {
                int t = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = t;
                lo++;
                hi--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Before: " + Arrays.deepToString(m));
        rotate(m);
        System.out.println("After:  " + Arrays.deepToString(m));
    }
}
