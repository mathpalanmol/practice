package string;

// If the length of string is n, then there can be n*(n+1)/2 possible substrings.
public class PrintAllSubStrings {

	public static void main(String[] args) {
		String str = "abc";
		// generate1(str, 0, str.length());
//		printSequence(str, "");
		printSubStrings(str);
		// }
	}

	private static void printSubStrings(String str) {
		for (int i = 0; i < str.length(); i++) {
			String str1 = str.substring(i, i+1);
			System.out.println(str1);
			for(int j=i+1; j< str.length() ; j++) {
				System.out.println(str1 + str.substring(i+1, j+1));
			}
		}
	}

	// This is to print all subsequence.
	private static void printSequence(String str, String out) {
		if (str.length() == 0) {
			System.out.println(out);
			return;
		}
		printSequence(str.substring(1), out);
		printSequence(str.substring(1), out + str.substring(0, 1));
	}

	// This is to print all substrings.

}
