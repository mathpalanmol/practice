package test;

// Given a list of words, find if any of the two words can be joined to form a palindrome. Examples: Input : list[] = {"heelk", "girls", "or", "lrig", "abc", "bc"} Output : Yes

public class PalindromPair {

	public static void main(String[] args) {
//		String[] inputs = { "heelk", "girls", "or", "lrig", "abc", "bc" };
		String[] inputs = {"abc", "xyxcba", "heelst", "or", "leeh", "bc"};
		boolean flag = false;
		for (int i = 0; i < inputs.length; i++) {
			for (int j = i + 1; j < inputs.length; j++) {
				String value = inputs[i] + inputs[j];
				boolean palindrom = checkPalindrom(value.toCharArray());
				if (palindrom) {
					System.out.println("Yes");
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}

		}
		if(!flag) {
			System.out.println("No");
		}

	}

	private static boolean checkPalindrom(char[] cs) {
		int i = 0;
		int j = cs.length - 1;
		while (i < j) {
			if (cs[i] != cs[j]) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

}
