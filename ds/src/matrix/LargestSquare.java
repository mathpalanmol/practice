package matrix;

import java.util.Arrays;

//Largest Square of 1's in A Matrix
public class LargestSquare {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 1, 1 },
				           { 1, 1, 1, 1, 1 }, 
				           { 1, 0, 1, 0, 1 }, 
				           { 1, 1, 1, 1, 1 } };
		int[][] clone = Arrays.copyOf(matrix, matrix.length);

		int count = getMaxOneSquareCount(matrix, 0, 0); // 0(nm)2
		
		//
		int maxCount = getMaxOneSquareCount(matrix, clone);
		System.out.println(count);
		System.out.println(maxCount);

	}

	private static int getMaxOneSquareCount(int[][] matrix, int[][] clone) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0 || matrix[i][j] == 0)
					continue;
				clone[i][j] = matrix[i][j] + getMin(clone[i - 1][j], clone[i - 1][j - 1], clone[i][j - 1]);
			}
		}
		return getMax(clone);
	}

	private static int getMax(int[][] clone) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < clone.length; i++) {
			for (int j = 0; j < clone[0].length; j++) {
				if (clone[i][j] > max)
					max = clone[i][j];
			}
		}
		return max;
	}

	private static int getMin(int i, int j, int k) {

		return Math.min(i, Math.min(j, k));
	}

	private static int getMaxOneSquareCount(int[][] matrix, int row, int col) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					int m = i;
					int n = j;
					boolean flag = false;
					int sqlen = 1;// every element form square of size 1.
					while ((m + 1) < matrix.length && (n + 1) < matrix[0].length && matrix[i][n + 1] == 1
							&& matrix[m + 1][j] == 1) {
						m++;
						n++;
						sqlen++;
						flag = true;
					}
					if (flag) {

						if (validate(matrix, i, j, sqlen)) {
							if (sqlen > max)
								max = sqlen;
						}
					}
				}
			}

		}
		return max;
	}

	private static boolean validate(int[][] matrix, int row, int col, int len) {
		for (int i = row; i < row + len; i++) {
			for (int j = col; j < col + len; j++) {
				if (matrix[i][j] != 1)
					return false;
			}
		}
		return true;
	}

}
