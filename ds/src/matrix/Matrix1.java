package matrix;

// find max length square matrix with 1 in m*n matrix which contains only 0 and 1.
public class Matrix1 {
	static int row = 5;
	static int column = 5;
	static int[][] ary = new int[row][column];

	void populate() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
//				double random = Math.random();
//				int temp = (int) (random * 10);
				ary[i][j] = 1;//temp % 2;
			}
		}
	}

	void print() {
		System.out.println("Printing Input: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(ary[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}

	void calculate() {
		for (int i = 0; i < row - 1; i++) { // no need to evaluate last row.
			for (int j = 0; j < column - 1; j++) {// one column before last
				int x = 1;
				int length = 0;
				if (ary[i][j] == 1) {
					while ((j + x) < column && (i + x) < row && ary[i][j + x] == 1 && ary[i + x][j] == 1) {
						x++;
						length++;
					}
					while (length != 0) {
						boolean isAlike = check(i, j, length);
						if (isAlike) {
							System.out.println("\n*******************\n");
							printOutput(i, j, length);
							
						}
						length--;
					}
				}

			}
		}
	}

	private void printOutput(int row, int column, int len) {// always add row and column
		for (int i = row; i <= row + len; i++) {
			for (int j = column; j <= column + len; j++) {
				System.out.print(ary[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean check(int row, int column, int k) {
		for (int i = row; i <= row + k; i++) {
			for (int j = column; j <= column + k; j++) {
				if (ary[i][j] != 1)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Matrix1 ref = new Matrix1();
		ref.populate();
		ref.print();
		ref.calculate();
	}

}
