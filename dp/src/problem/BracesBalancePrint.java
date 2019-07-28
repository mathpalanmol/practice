package problem;
// Question: For given n i.e pair of braces, find all possible balanced braces. for example run this program.

public class BracesBalancePrint {

	public static void main(String[] args) {
		int pair = 3;
		int open = pair; // open brace count
		int close = pair; // close brace count
		printBalancedBraces("", open, close);

	}

	private static void printBalancedBraces(String str, int open, int close) {
		if (open == 0 && close == 0)
			print(str);
		if (close < open) // if at any point close is smaller than open then it can be balanced no need to proceed further.  
			return;       // consider n=2 and ")((" condition, it get never get balanced
		//whatever open we have utilized there should be always some closed braced remaining to counter balance it.
		if (open > 0)
			printBalancedBraces(str + "(", open - 1, close);
		if (close > 0)
			printBalancedBraces(str + ")", open, close - 1);
	}

	private static void print(String str) {
		System.out.println(str);
	}

}
