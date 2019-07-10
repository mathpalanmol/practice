package matrix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//4
//..X.
//..X.
//....
//....
//BFS IN MATRIX/GRID
public class BfsGrid {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[][] intAry = new int[size][size];
		boolean[][] bolAry = new boolean[size][size];// visited array
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				intAry[i][j] = scan.nextInt();
			}
		}
		int sRow = scan.nextInt();
		int sCol = scan.nextInt();
		bfs(intAry, bolAry, sRow, sCol);

		System.out.println("Printing input Array: ");
		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry.length; j++) {
				System.out.print(intAry[i][j] + " ");
			}
			System.out.println();
		}
	}

	// put cell in q from where you want to start bfs
	private static void bfs(int[][] intAry, boolean[][] bolAry, int sRow, int sCol) {
		int len = intAry.length;
		Queue<Entry> q = new LinkedList<Entry>();
		Entry fEntry = new Entry(intAry[sRow][sCol], sRow, sCol);
		q.offer(fEntry);
		bolAry[sRow][sCol] = true;
		while (!q.isEmpty()) {
			Entry entry = q.poll();
			entry.isVisited = false;
			System.out.println(entry.value);
			sRow = entry.sRow;
			sCol = entry.sCol;
			// we should consider diagonal also
			if (sCol + 1 < len && !bolAry[sRow][sCol + 1]) {// right
				Entry entry2 = new Entry(intAry[sRow][sCol + 1], sRow, sCol + 1);
				q.offer(entry2);
				bolAry[sRow][sCol + 1] = true;
			}
			if (sCol - 1 >= 0 && !bolAry[sRow][sCol - 1]) {// left
				Entry entry2 = new Entry(intAry[sRow][sCol - 1], sRow, sCol - 1);
				q.offer(entry2);
				bolAry[sRow][sCol - 1] = true;
			}
			if (sRow + 1 < len && !bolAry[sRow + 1][sCol]) {// down
				Entry entry2 = new Entry(intAry[sRow + 1][sCol], sRow + 1, sCol);
				q.offer(entry2);
				bolAry[sRow + 1][sCol] = true;
			}
			if (sRow - 1 >= 0 && !bolAry[sRow - 1][sCol]) {// up
				Entry entry2 = new Entry(intAry[sRow - 1][sCol], sRow - 1, sCol);
				q.offer(entry2);
				bolAry[sRow - 1][sCol + 1] = true;
			}

		}

	}

	static class Entry {
		int value;
		int sRow;
		int sCol;
		boolean isVisited;

		public Entry(int value, int sRow, int sCol) {
			super();
			this.value = value;
			this.sRow = sRow;
			this.sCol = sCol;
		}

	}

	// If diagonal moves are allowed.
	private static void bfsPractice(int[][] matrix, int row, int col, boolean[][] temp) {
		Queue<Entry1> q = new LinkedList<Entry1>();
		Entry1 entry = new Entry1(row, col);
		q.add(entry);
		temp[row][col] = true;
		int level = 1;
		while (!q.isEmpty()) {
			Entry1 entry1 = q.poll();
			System.out.println("val: " + matrix[entry1.sRow][entry1.sCol]);
			// left
			if (col - 1 >= 0 && !temp[row][col - 1]) {
				q.add(new Entry1(row, col - 1));
			}
			// right
			if (col + 1 < matrix[0].length && !temp[row][col + 1]) {
				q.add(new Entry1(row, col - 1));
			}
			// up
			if (row - 1 >= 0 && !temp[row - 1][col]) {
				q.add(new Entry1(row - 1, col));
			}
			// down
			if (row + 1 >= matrix.length && !temp[row + 1][col]) {
				q.add(new Entry1(row + 1, col));
			}
			// left-up-diagonal
			if (col - 1 >= 0 && row - 1 >= 0 && !temp[row - 1][col - 1]) {
				q.add(new Entry1(row - 1, col - 1));
			}
			// left-down-diagonal
			if (col - 1 >= 0 && row + 1 < matrix.length && !temp[row + 1][col - 1]) {
				q.add(new Entry1(row + 1, col - 1));
			}
			// right-up-diagonal
			if (row - 1 >= 0 && col + 1 < matrix[0].length && !temp[row - 1][col + 1]) {
				q.add(new Entry1(row - 1, col + 1));
			}
			// right-down-diagonal
			if (col + 1 < matrix[0].length && row + 1 < matrix.length && !temp[row + 1][col + 1]) {
				q.add(new Entry1(row + 1, col + 1));
			}

		}
	}

	static class Entry1 {
		int sRow;
		int sCol;
		boolean isVisited;

		public Entry1(int sRow, int sCol) {
			super();
			this.sRow = sRow;
			this.sCol = sCol;
		}
	}

}
