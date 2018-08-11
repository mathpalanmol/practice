package problem;

public class MaxSquare1 {
	// complixity: time: O(mXn), space: O(mXn) 
	// dp solution

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1,1, 1, 0 }, { 1, 1, 1, 1 } };
		int[][] adhoc = matrix.clone();// new boolean[matrix.length][matrix[0].length];
		calculate(matrix, adhoc);
		int count = getMax(adhoc);
		System.out.println("max square nXn, n: " + count);

	}

	private static int getMax(int[][] adhoc) {
		int max = Integer.MIN_VALUE;
		// populate adhoc
		for (int i = 1; i < adhoc.length; i++) {
			for (int j = 1; j < adhoc[0].length; j++) {
                if(adhoc[i][j]>max)
                	max = adhoc[i][j];
			}
		}
		return max;
	}

	//populate adhoc
	
	private static void calculate(int[][] matrix, int[][] adhoc) {
		// leave 1st row and col as it is. 
		// every time we are calculating for fourth(lower-right) cell.
		// as per formula it's value will be min(left,upperleft diagonal, up)+1;
		// for first row and col min(left,upperleft diagonal, up) will be cell value itself. out of 4, 2 cell will always be zero.

		// populate adhoc
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					// left,upper-left-diagonal,up
					adhoc[i][j] = getMin(adhoc[i][j - 1], adhoc[i - 1][j - 1], adhoc[i - 1][j]) + 1;
				}
			}
		}

	}

	private static int getMin(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}

}
