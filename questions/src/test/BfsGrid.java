package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//4
//..X.
//..X.
//....
//....
//BFS IN MATRIX/GRID
public class BfsGrid{
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
		bfs(intAry,bolAry, sRow, sCol);

		 System.out.println("Printing input Array: ");
		 for (int i = 0; i < intAry.length; i++) {
		 for (int j = 0; j < intAry.length; j++) {
		 System.out.print(intAry[i][j] + " ");
		 }
		 System.out.println();
		 }
	}

	private static void bfs(int[][] intAry, boolean[][] bolAry, int sRow, int sCol) {
		int len = intAry.length;
		Queue<Entry> q = new LinkedList<Entry>();
		Entry fEntry = new Entry(intAry[sRow][sCol], sRow, sCol);
		q.offer(fEntry);
		bolAry[sRow][sCol] = true;
		while(!q.isEmpty()){
			Entry entry = q.poll();
			entry.isVisited = false;
			System.out.println(entry.value);
			sRow = entry.sRow;
			sCol = entry.sCol;
			if(sCol+1<len && !bolAry[sRow][sCol+1]){//right
				Entry entry2 = new Entry(intAry[sRow][sCol+1], sRow, sCol+1);
				q.offer(entry2);
				bolAry[sRow][sCol+1] = true;
			}
			if(sCol-1>=0 && !bolAry[sRow][sCol-1]){//left
				Entry entry2 = new Entry(intAry[sRow][sCol-1], sRow, sCol-1);
				q.offer(entry2);
				bolAry[sRow][sCol-1] = true;
			}
			if(sRow+1<len && !bolAry[sRow+1][sCol]){//down
				Entry entry2 = new Entry(intAry[sRow+1][sCol], sRow+1, sCol);
				q.offer(entry2);
				bolAry[sRow+1][sCol] = true;
			}
			if(sRow-1>=0 && !bolAry[sRow-1][sCol]){//up
				Entry entry2 = new Entry(intAry[sRow-1][sCol], sRow-1, sCol);
				q.offer(entry2);
				bolAry[sRow-1][sCol+1] = true;
			}
			
		}
		
	}
	 static class Entry{
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
}
