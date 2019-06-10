package problem;

public class Knapshak0_1 {

	public static void main(String[] args) {
		int[] weights = { 1, 3, 4, 5 };
		int[] values = { 1, 4, 5, 7 };
		int capacity = 7;
		// first row and col will be considered as zero
		int[][] auxAry = new int[weights.length + 1][capacity + 1];// capacity+1; to include '0' as first cell.
		int value = getMaxValue(weights, values, capacity, auxAry);
		print(auxAry);
		System.out.println("Capacity: " + capacity + " value: " + value);
	}

	/*
	 * 1. Consider first row and col as zero. 2. row will be marked as weights and
	 * col will be marked as 0 to total weight. 3. for every weight check if it can
	 * contribute in forming given weight 4. if difference is negative it means we
	 * can exclude current weight(can't take fraction). so above cell will be the
	 * solution. 5. else get its value and add it to remaining sum[7-4; diff=3;let
	 * say r0w=2--> add[row-1][diff] 6. getMax: of the column with above cell
	 * (include weight and exclude weight)
	 */
	private static int getMaxValue(int[] weights, int[] values, int capacity, int[][] auxAry) {

		for (int i = 1; i < auxAry.length; i++) {
			for (int j = 1; j < auxAry[0].length; j++) {

				int sol = auxAry[i - 1][j];// above cell value, assume current weight doesn't contribute... anyways
				                           // we need this value for sum
				int diff = j - weights[i-1]; // j is equivalent to total weight for this iteration, or you can keep a
											// separate array from 0 to capacity. here j is always equal to this value
											// so we are using j as W
				if (diff >= 0) {
					sol = getMax(sol, getMax(sol, values[i-1] + auxAry[i - 1][diff]));
				}
				auxAry[i][j] = sol;
			}
		}

		return auxAry[auxAry.length - 1][auxAry[0].length - 1];
	}

	public static int getMax(int a, int b) {
		return Math.max(a, b);
	}

	public static void print(int[][] ary2d) {
		for (int[] ary : ary2d) {
			for (int val : ary) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

}
