package matrix;

import java.util.Objects;
import java.util.Scanner;
//You are given a grid with both sides equal to n. Rows and columns are numbered from 0 to n-1. There is a castle on the intersection of the ath row and the bth column.

//Your task is to calculate the minimum number of steps it would take to move the castle from its initial position to the goal position.

//3 -- row and column 
//. X .
//. X .
//. . .
//0 0 0 2 -- source and destination row and column.

//3 output

//3
//.X.
//.X.```
//...

//Note: You can move the castle from cell (a, b)  to any (c,d)  in a single step if there is a straight horizontal line or a straight vertical line between 
//and  that does not contain any forbidden cell. Here, "X" denotes a forbidden cell
public class Castle2D {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		long l = Long.MAX_VALUE;
	    System.out.println(l);
	    l= l + 20;
	    System.out.println(l>>>32);
	    
	//    int i = Integer.MAX_VALUE;
	    
	    
		Objects.hashCode(scan);
		int size = scan.nextInt();
		char[][] chAry = new char[size][size];
		boolean[][] bolAry = new boolean[size][size];// visited array
		for (int i = 0; i < size; i++) {
			String str = scan.next();
			for (int j = 0; j < size; j++) {
				chAry[i][j] = str.charAt(j);
			}
		}
		int sRow = 0;
		int sCol = 0;
		int dRow = 0;
		int dCol = 2;
		int min = getMinSteps(chAry, bolAry, sRow, sCol, dRow, dCol);
		System.out.println("\n\nMinimum steps would be: " + min);

	}

	private static int getMinSteps(char[][] chAry, boolean[][] bolAry, int sRow, int sCol, int dRow, int dCol) {
		int steps = 0;
		steps = getMinSteps(chAry, bolAry, sRow, sCol, dRow, dCol, steps,"");
		return steps;
	}

	// static boolean skip = false;
	static int min = Integer.MAX_VALUE;
	static String preDirection = "";

	
	// Direction is required for this note: //Note: You can move the castle from cell (a, b)  to any (c,d)  in a single step if there is a straight horizontal line 
	private static int getMinSteps(char[][] chAry, boolean[][] bolAry, int sRow, int sCol, int dRow, int dCol,
			int steps, String direction) {

		if (sRow < 0 || sCol < 0 || sRow >= chAry.length || sCol >= chAry.length || dRow < 0 || dCol < 0
				|| dRow >= chAry.length || dCol >= chAry.length || chAry[sRow][sCol] == 'X' || bolAry[sRow][sCol]) {
			return steps;
		}
		if (sRow == dRow && sCol == dCol) {
			if (steps < min) {
				min = steps;
				return steps;
			}
		}
		bolAry[sRow][sCol] = true;
		if(!(preDirection.equals(direction))) {
		steps++;
		}
		preDirection= direction;
		getMinSteps(chAry, bolAry, sRow, sCol + 1, dRow, dCol, steps, "right");// right
		getMinSteps(chAry, bolAry, sRow, sCol - 1, dRow, dCol, steps, "left");// left
		getMinSteps(chAry, bolAry, sRow - 1, sCol, dRow, dCol, steps, "up");// up
		getMinSteps(chAry, bolAry, sRow + 1, sCol, dRow, dCol, steps, "down");// down
		bolAry[sRow][sCol] = false;

		return min;
	}

}
