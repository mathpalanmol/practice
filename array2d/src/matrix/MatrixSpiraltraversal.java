package matrix;

public class MatrixSpiraltraversal {

	// incomplete
	// TODO print center element.
	public static void main(String[] args) {
		// int[][] matrix = { { 1, 2, 3, 4, 5 },
		// { 6, 7, 8, 9, 10 },
		// { 11, 12, 13, 14, 15 },
		// { 16, 17, 18, 19, 20 },
		// { 21, 22, 23, 24, 25 },
		// };
		int[][] matrix = { { 1, 2, 3 }, 
				           { 4, 5, 6 }, 
				           { 7, 8, 9 }, };
		printSpiral(matrix);
	}

	private static void printSpiral(int[][] matrix) {
		int rowmin = 0;
		int rowmax = matrix.length - 1;
		int colmin = 0;
		int colmax = matrix[0].length - 1;
		// start with 0,0
		// traverse first row. left-->right. increase rowmin i.e remove first
		// row..cause: we've start with 1,maxcol
		// traverse last col. decrease colmax... remove last col
		// traverse last row, right -> left...rowmax-- remove last row
		// traverse first col, bottom-->up decrease col min ++ -- remove first col
		while (colmin < colmax && rowmin < rowmax) {
			// traverse first row
			for (int i = colmin; i <= colmax; i++) {
				int x = matrix[rowmin][i];
				System.out.print(x + ", ");
			}
			rowmin++;
			// top to bottom last col
			for (int i = rowmin; i <= rowmax; i++) {
				int x = matrix[i][colmax];
				System.out.print(x + ", ");
			}
			colmax--;
			// right to left last row
			for (int i = colmax; i >= colmin; i--) {
				int x = matrix[rowmax][i];
				System.out.print(x + ", ");
			}
			rowmax--;
			// bottom to up first col
			for (int i = rowmax; i >= rowmin; i--) {
				int x = matrix[i][colmin];
				System.out.print(x + ", ");
			}
			colmin++;
		}	// while end
		
		//if columns are of odd count then mid element exist otherwise not. 
		if ((matrix[0].length % 2 == 1)) {
            System.out.println(matrix[matrix[0].length / 2][matrix[0].length / 2]);
		}
	}

}
