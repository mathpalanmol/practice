package matrix;

import java.util.Arrays;

// input
//[0, 1, 2, 3, 4]
//[6, 7, 8, 9, 10]
//[11, 12, 13, 14, 15]
//[16, 17, 18, 19, 20]
//[21, 22, 23, 24, 25]

//output
//[6, 1, 2, 3, 4]
//[11, 12, 7, 8, 5]
//[16, 17, 13, 9, 10]
//[21, 18, 19, 14, 15]
//[22, 23, 24, 25, 20]

public class RotateMatrixClockwise {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, 
				           { 6, 7, 8, 9, 10 }, 
				           { 11, 12, 13, 14, 15 }, 
				           { 16, 17, 18, 19, 20 },
				           { 21, 22, 23, 24, 25 }, 
				           };
		int[][] output2d = rotateAntiClock(matrix);
		print(output2d);
	}

	private static void print(int[][] output2d) {
		for(int[] ary : output2d) {
			System.out.println(Arrays.toString(ary));
		}
		
	}
//clockwise
	private static int[][] rotateAntiClock(int[][] matrix) {
		int rowmin = 0;
		int rowmax = matrix.length-1;
		int colmin = 0;
		int colmax = matrix[0].length-1;
		// start with 0,0
		// traverse first row. left-->right. increase rowmin i.e remove first row..cause: now we've start with [1,maxcol] 
		// traverse last col. decrease colmax... remove last col
		// traverse last row, right -> left...rowmax-- remove last row
		// traverse first col, bottom-->up decrease col min ++ -- remove first col
		while (colmin < colmax && rowmin < rowmax) {
			int temp = 0; // will keep replaced value in temp.. for first cell there is no replaced value for now
			// left to right row
			int r= rowmin;
			int c= colmin;// keep r and c and use later 
			 //to populate the cell with temp value. 
			// it's a kind of cycle so first cell will be replace temp value.
			for (int i = colmin; i <= colmax; i++) { // col min--> max horizontal left-->right
				int x = matrix[rowmin][i];
				matrix[rowmin][i] = temp;
				temp = x;
			}
			rowmin++;
			print(matrix);
			System.out.println("***********");
			// top to bottom last col
			for (int i = rowmin; i <= rowmax; i++) {
				int x = matrix[i][colmax]; // important switching betwen x and temp
				matrix[i][colmax] = temp;
				temp = x;
			}
			colmax--;
			print(matrix);
			System.out.println("***********");
			// right to left last row
			for (int i = colmax; i >= colmin; i--) { // col max--> horizontal right-->left
				int x = matrix[rowmax][i];
				matrix[rowmax][i] = temp;
				temp = x;
			}
			rowmax--;
			print(matrix);
			System.out.println("***********");
			// bottom to up first col
			for (int i = rowmax; i >= rowmin; i--) {
				int x = matrix[i][colmin];
				matrix[i][colmin] = temp;
				temp = x;
			}
			colmin++;
			
			print(matrix);
			System.out.println("***********");
			
			matrix[r][c] = temp; // important
		}
		return matrix;
	}

}
