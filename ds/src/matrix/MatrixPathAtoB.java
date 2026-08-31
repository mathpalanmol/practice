package matrix;
// can't travel diagonal
public class MatrixPathAtoB {
	static int[][] matrix;

	public static void main(String[] args) {
		populateMatrix();
		System.out.println("\n\nOutput:");
		printPath(matrix, 0, 0, 0, 2);

	}

	private static void printPath(int[][] matrix, int sRow, int sCol, int dRow, int dCol) {
		int[] ary = new int[50];
		boolean[][] bary = new boolean[matrix.length][matrix[0].length];
		int index = 0;
		printPath(matrix, bary, ary, index, sRow, sCol, dRow, dCol);
	}

	private static void printPath(int[][] matrix, boolean[][] bary, int[] ary, int index, int sRow, int sCol, int dRow,
			int dCol) {
		if (sRow < 0 || sCol < 0 || sRow >= matrix.length || sCol >= matrix[0].length || bary[sRow][sCol])
			return;
		ary[index++] = matrix[sRow][sCol];
		
		if (sRow == dRow && sCol == dCol) {
			for (int i = 0; i < index; i++) {
				System.out.print(ary[i] + "->");
			}
			System.out.println();
		}

		
		bary[sRow][sCol] = true;
		printPath(matrix, bary, ary, index, sRow, sCol + 1, dRow, dCol);// right
		printPath(matrix, bary, ary, index, sRow, sCol - 1, dRow, dCol);// left
		printPath(matrix, bary, ary, index, sRow - 1, sCol, dRow, dCol);// up
		printPath(matrix, bary, ary, index, sRow + 1, sCol, dRow, dCol);// down
		bary[sRow][sCol] = false;

	}

	private static void populateMatrix() {
		matrix = new int[3][3];
		int value = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = value;
				System.out.print(value + " ");
				value++;
			}
			System.out.println();
		}
	}

}
