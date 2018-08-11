package matrix;


//Given the N*N matrix, find the given number in the matrix. All rows are sorted. And each row first element is less than the previous row last index. 
//input : 
//
//[1,3,5,7,9] 
//[11,13,15,16,20] 
//[21,22,23,24,25] 
//[30,32,35,40,45] 
//
//Given Num : 23 

/*
 * Approach is to do binary search both vertically and horizontally. 
 * Vertical serach to find the right row where given key can exist. trick is it's always present in low - 1 if high>low.
 * horizontal search will take input of vertical search which is rowno and will perform binary seach in the rowno.
 * */
public class SortedMatrix {

	public static void main(String[] args) {
		int[][] ary2 = { { 2, 4, 6, 8 }, { 10, 12, 14, 16 }, { 18, 20, 22, 24 }, { 26, 28, 30, 32 },
				{ 34, 36, 38, 40 } };
		int key = 7;
		findNo(ary2, key);

	}

	private static void findNo(int[][] ary2, int key) {
		Result result = binarySearchV(ary2, 0, ary2.length - 1, 0, key);
		System.out.println(result);
		if (!result.found) {
			result.found = binarySearchH(ary2, 0, ary2[0].length - 1, result.rowInded, key);
		}
		System.out.println(result.found);
	}

	static boolean binarySearchH(int[][] ary, int clow, int chigh, int row, int key) {
		if (clow > chigh)
			return false;
		int mid = clow + (chigh - clow) / 2;
		if (ary[row][mid] == key)
			return true;
		if (key < ary[row][mid])
			return binarySearchH(ary, clow, mid - 1, row, key);
		else
			return binarySearchH(ary, mid + 1, chigh, row, key);

	}

	static Result binarySearchV(int[][] ary, int rlow, int rhigh, int col, int key) {
		if (rlow > rhigh) {
			return new Result(false, --rlow);
		}
		int mid = rlow + (rhigh - rlow) / 2;
		if (ary[mid][col] == key)
			return new Result(true);
		if (key < ary[mid][col])
			return binarySearchV(ary, rlow, mid - 1, col, key);
		else
			return binarySearchV(ary, mid + 1, rhigh, col, key);

	}

	public static class Result {
		boolean found;
		int rowInded;

		public Result(boolean found, int rowInded) {
			super();
			this.found = found;
			this.rowInded = rowInded;
		}

		public Result(boolean found) {
			super();
			this.found = found;
		}

		@Override
		public String toString() {
			return "Result [found=" + found + ", rowInded=" + rowInded + "]";
		}

	}

}
