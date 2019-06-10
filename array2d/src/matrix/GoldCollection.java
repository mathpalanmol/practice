package matrix;

//Given a gold mine of n*m dimensions. 
//Each field in this mine contains an integer which is the amount of gold in tons. 
//Initially the miner is in first column but can be at any row i. 
//He can move only (right , right up , right down ) that is from a given cell, the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. 
//Find out maximum amount of gold he can collect.


public class GoldCollection {
	static int rowSize = 4;
	static int colSize = 4;
	static int[][] ary = new int[rowSize][colSize];

	static void populate() {
		int count = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				ary[i][j] = ++count%10;
			}
		}
	}

	static void print() {
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++) {
				System.out.print(ary[i][j] + " ");
			}
			System.out.println();
		}
	}
// Fill: right to left column wise... ie. nxt last col to first col.
	static void collectGold() {
		for (int j = colSize - 2; j >= 0; j--) {
			for (int i = 0; i < rowSize; i++) {
				int right = (j + 1) == colSize ? 0 : ary[i][j + 1];
				int rdown = (i + 1) == rowSize || (j + 1) == colSize ? 0 : ary[i + 1][j + 1];
				int rup = (i - 1) < 0 || (j + 1) == colSize ? 0 : ary[i - 1][j + 1];
				int mValue = Math.max(Math.max(right, rdown), rup);
				ary[i][j] = ary[i][j] + mValue;
			}
		}
	}

	public static void main(String[] args) {
		populate();
		System.out.println("***Printing input***");
		print();
		collectGold();
		System.out.println("***Printing output***");
		print();
	}

}
