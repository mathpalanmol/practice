package problem;
/*Given a value N, if we want to make change for N cents, 
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, 
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
*/

/*Given a value N, if we want to make change for N cents, 
and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and S = {2, 5, 3, 6}, 
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5*/
/*
 * Steps:
 * 1. Create memorization matrix column as denomination no's{1,2,3} and row contains no's up to the sum ex: sum 4{1,2,3,4}. 
 * first row and col should contain 0.
 * 2. For every denomination check both cases:
 * Exclude denomination case: takes 'UP' cell value --> s1
 * Include denomination case: subtract current denomination value from sum 
 * and find remaining sum value in memorization matrix-->s2
 * Add s1+s2 to fill current cell
 * 
 * */

public class CoinChangeProblem {
	public static void main(String[] args) {
		int[] sumAry = { 1, 2, 3, 4, 5 };
		int[] coinAry = { 1, 2, 3, 4, 5 };
		int[][] ary = new int[coinAry.length + 1][sumAry.length + 1];
		int ways = coinExchange(sumAry, coinAry, ary);
		System.out.println("No of ways: " + ways);
	}

	// col: coins ; row : sum
	private static int coinExchange(int[] sumAry, int[] coinAry, int[][] ary) {
		// populate first col as '1'; Reason '0' sum can be obtained with any '0...n'
		// denominations.
		for (int i = 0; i < ary.length; i++) {
			ary[i][0] = 1;
		}

		for (int i = 1; i < ary.length; i++) {
			for (int j = 1; j < ary.length; j++) {
				// sumAry, coinAry --> doesn't contain '0' so -1.
				// for every coin we need to scan all columns i.e to achive all sums
				// j-1 and i-1
				int diff = sumAry[j - 1] - coinAry[i - 1];
				int value = ary[i - 1][j]; // current above cell.
				// if diff is -ve, it means coin is greater than sum itself.
				if (diff >= 0) {
					// for remaining sum check precomputed value.
					// 3(sum)-1(coin) = 2 --> ary[i-->samerow][2] will give the no of ways to achive
					// it.
					value += ary[i][diff];
				}
				ary[i][j] = value;
			}
		}
		print(ary);
		return ary[ary.length - 1][ary[0].length - 1];
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
