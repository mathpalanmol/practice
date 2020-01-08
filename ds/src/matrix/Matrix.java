package matrix;

// Evaluation: TODO
public class Matrix {
	static int row = 5;
	static int column = 5;
	static int[][] ary = new int[row][column];

	void populate() {
		int count = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				ary[i][j] = count % 10 == 0 ? 1 : count % 10;
				count++;
			}
		}
	}

	void print() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(ary[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("**********************");
	}

	void calculate() {

		for (int j = 0; j < column; j++) {
			int entryRow = 0;
			for (int i = 0; i < row - j; i++) {
				entryRow = i;
				populate(ary[i][j], i + j, j);
			}
			int count = entryRow + 1 + j; // row + current column + 1
			for (int x = j + 1; x < column; x++) {
				populate(ary[entryRow][x], count, j);
				count++;
			}
		}
	}

	int[][] outputAry = new int[row + column - 1][column];
	int outputRow = row + column - 1;
	int outputColumn = column;

	private void populate(int value, int row, int column) {
		outputAry[row][column] = value;

	}

	void printResult() {
		for (int i = 0; i < outputRow; i++) { // check the length
			for (int j = 0; j < outputColumn; j++) {
				if (outputAry[i][j] == 0)
					System.out.print(" ");
				else
					System.out.print(outputAry[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Matrix ref = new Matrix();
		ref.populate();
		ref.print();
		ref.calculate();
		System.out.println("output");
		ref.printResult();

	}



}
