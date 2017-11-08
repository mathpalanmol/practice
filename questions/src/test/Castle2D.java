package test;

import java.util.Scanner;
//You are given a grid with both sides equal to n. Rows and columns are numbered from 0 to n-1. There is a castle on the intersection of the ath row and the bth column.

//Your task is to calculate the minimum number of steps it would take to move the castle from its initial position to the goal position.

//3 -- row and column 
//. X .
//. X .
//. . .
//0 0 0 2 -- source and destination row and colunmn.

//3 output

//Note: You can move the castle from cell (a, b)  to any (c,d)  in a single step if there is a straight horizontal line or a straight vertical line between 
//and  that does not contain any forbidden cell. Here, "X" denotes a forbidden cell
public class Castle2D {

	// public static void main(String[] args) {
	// Scanner scan = new Scanner(System.in);
	// int size = scan.nextInt();
	// char[][] chAry = new char[size][size];
	// boolean[][] bolAry = new boolean[size][size];// visited array
	// for (int i = 0; i < size; i++) {
	// for (int j = 0; j < size; j++) {
	// chAry[i][j] = scan.next().charAt(0);
	// }
	// }
	// int sRow = scan.nextInt();
	// int sCol = scan.nextInt();
	// int dRow = scan.nextInt();
	// int dCol = scan.nextInt();
	// int min = getMinSteps(chAry, bolAry, sRow, sCol, dRow, dCol);
	// System.out.println("Printing input Array: ");
	// for (int i = 0; i < chAry.length; i++) {
	// for (int j = 0; j < chAry.length; j++) {
	// System.out.print(chAry[i][j] + " ");
	// }
	// System.out.println();
	// }
	// System.out.println("\n\nMinimum steps would be: " + min);
	//
	// }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		char[][] chAry = new char[size][size];
		boolean[][] bolAry = new boolean[size][size];// visited array
		for (int i = 0; i < size; i++) {
			String str = scan.next();
			for (int j = 0; j < size; j++) {
				chAry[i][j] = str.charAt(j);
			}
		}
		int sRow = scan.nextInt();
		int sCol = scan.nextInt();
		int dRow = scan.nextInt();
		int dCol = scan.nextInt();
		int min = getMinSteps(chAry, bolAry, sRow, sCol, dRow, dCol);
		// System.out.println("Printing input Array: ");
		// for (int i = 0; i < chAry.length; i++) {
		// for (int j = 0; j < chAry.length; j++) {
		// System.out.print(chAry[i][j] + " ");
		// }
		// System.out.println();
		// }
		System.out.println("\n\nMinimum steps would be: " + min);

	}

	private static int getMinSteps(char[][] chAry, boolean[][] bolAry, int sRow, int sCol, int dRow, int dCol) {
		String move = "move";
		String preStep = "previous";
		int steps = -1;
		steps = getMinSteps(chAry, bolAry, sRow, sCol, dRow, dCol, steps, move, preStep);
		if (steps == Integer.MAX_VALUE)
			System.out.println("Destination can't be 'X' ie. Abondened cell");
		return steps;
	}

	// static boolean skip = false;
	static int min = Integer.MAX_VALUE;

	private static int getMinSteps(char[][] chAry, boolean[][] bolAry, int sRow, int sCol, int dRow, int dCol,
			int steps, String move, String preStep) {
		if (steps < min) {
			if (sRow < 0 || sCol < 0 || sRow >= chAry.length || sCol >= chAry.length || dRow < 0 || dCol < 0
					|| dRow >= chAry.length || dCol >= chAry.length || chAry[sRow][sCol] == 'X' || bolAry[sRow][sCol]) {
				return steps;
			} else if (sRow == dRow && sCol == dCol) {

				if (!preStep.equals(move))// this is successful move and we
											// should count it.
					steps++;
//				System.out.println(steps);
				if (steps < min)
					min = steps;
				return steps;
			} else {
				System.out.println(min);
				bolAry[sRow][sCol] = true;

				if (!preStep.equals(move))
					steps++;

				preStep = move;

				getMinSteps(chAry, bolAry, sRow, sCol + 1, dRow, dCol, steps, "right", preStep);// right
				getMinSteps(chAry, bolAry, sRow, sCol - 1, dRow, dCol, steps, "left", preStep);// left
				getMinSteps(chAry, bolAry, sRow - 1, sCol, dRow, dCol, steps, "up", preStep);// up
				getMinSteps(chAry, bolAry, sRow + 1, sCol, dRow, dCol, steps, "down", preStep);// down
				bolAry[sRow][sCol] = false;
			}
		}
		return min;
	}

}
