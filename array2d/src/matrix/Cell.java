package matrix;
//get Biggest Region with 1
public class Cell {

//	 1 1 0 0
//	 0 1 1 0
//	 0 0 1 0
//	 1 0 0 0
	// find area.
	static int rowLen = 4;
	static int colLen = 4;

	public static void main(String[] args) {

		int[][] grid = new int[rowLen][colLen];
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				grid[i][j] = (int) ((Math.random() * 10) % 2);
			}
		}
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\n\n" + getBiggestRegion(grid));
	}

	static int getBiggestRegion(int[][] grid){
		boolean[][] visitedAry = new boolean[rowLen][colLen];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				int count = countRegion(grid, visitedAry, i, j, 0);
				if (count > max)
					max = count;
			}

		}
		return max;
	}

	private static int countRegion(int[][] grid, boolean[][] visitedAry, int row, int column, int count) {
		if (row < 0 || row >= rowLen || column < 0 || column >= colLen)
			return count;

		if (grid[row][column] == 1 && !visitedAry[row][column]) {
			count++;
			visitedAry[row][column] = true;
			count = countRegion(grid, visitedAry, row, column + 1, count);// front
			count = countRegion(grid, visitedAry, row, column - 1, count);// back
			count = countRegion(grid, visitedAry, row - 1, column, count);// up
			count = countRegion(grid, visitedAry, row + 1, column, count);// down
			count = countRegion(grid, visitedAry, row - 1, column - 1, count);// diag
																				// upleft
			count = countRegion(grid, visitedAry, row - 1, column + 1, count);// diag
																				// upright
			count = countRegion(grid, visitedAry, row + 1, column - 1, count);// diag
																				// downleft
			count = countRegion(grid, visitedAry, row + 1, column + 1, count);// diag
																				// downright
		}
		return count;

	}

}
