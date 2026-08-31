package ds.graph;

public class Maximum1Island {

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 1, 0, 1, 1 }, 
				{ 1, 0, 0, 1 }, 
				{ 1, 0, 0, 0 }, 
				{ 1, 0, 1, 1 } };
		// To keep track of visited nodes.
		boolean[][] adhoc = new boolean[matrix.length][matrix[0].length];
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (adhoc[i][j] == false && matrix[i][j] == 1) {
					count = 0;
					getmax1Iland1(matrix, adhoc, count, i, j);
				}
			}
		}
		System.out.println("Max: " + max);
	}

	static int max = Integer.MIN_VALUE;
	static int cnt = 0;



	private static int getmax1Iland1(int[][] matrix, boolean[][] adhoc, int count, int row, int col) {
		if (!isValidMove(matrix, row, col) || matrix[row][col] == 0 || adhoc[row][col] == true) {
			return count;
		} else {
			adhoc[row][col] = true;
			count++;
			if (count > max) {
				max = count;
//				System.out.println("Max: " + max);
			}
			count = getmax1Iland1(matrix, adhoc, count, row, col - 1);// left
			count = getmax1Iland1(matrix, adhoc, count, row, col + 1);// right
			count = getmax1Iland1(matrix, adhoc, count, row - 1, col);// up
			count = getmax1Iland1(matrix, adhoc, count, row + 1, col);// down
			count = getmax1Iland1(matrix, adhoc, count, row - 1, col - 1);// left upper-diagonal
			count = getmax1Iland1(matrix, adhoc, count, row - 1, col + 1);// right upper-diagonal
			count = getmax1Iland1(matrix, adhoc, count, row + 1, col - 1);// lowerleft-diagonal
			count = getmax1Iland1(matrix, adhoc, count, row + 1, col + 1);// lowerright diagonal
		}
		return count;

	}

	private static boolean isValidMove(int[][] matrix, int row, int col) {
		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
			return false;
		return true;
	}

}
