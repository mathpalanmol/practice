package recursion;

// given a pair count, find all possible pairs.
// input: 2 i.e. 2 pair
// output: Possible outcome
// (())
// ()()

public class Braces {

	private static void printPair(int len, int lcnt, int rcnt, char[] chAry, int index) {
		
		if (index == len && lcnt == 0 && rcnt == 0) {
			System.out.println(new String(chAry));
			return;
		}
		if (rcnt < lcnt || index == len) // remove this and see the output.
			return;
		chAry[index] = '(';
		printPair(len, lcnt - 1, rcnt, chAry, index + 1);
		chAry[index] = ')';
		printPair(len, lcnt, rcnt - 1, chAry, index + 1);

	}

	public static void main(String[] args) {
		int pair = 2;
		int len = pair * 2;
         printPair(len, pair, pair, new char[len], 0);
	}
}
