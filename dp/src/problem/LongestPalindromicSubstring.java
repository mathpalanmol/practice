package problem;

//Longest Palindromic Substring
//Given a string, find the longest substring which is palindrome. 
//For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
//https://www.youtube.com/watch?v=obBdxeCx_Qs

// With dp complixity is Time complexity: O ( n^2 )
//Auxiliary Space: O ( n^2 )

public class LongestPalindromicSubstring {

	public static void main(String[] args) {

		String str = "forgeeksskeegfor";
		System.out.println("Length is: " + longestPalSubstr(str));
		bruteForceSol(str);
	}

	// O(n3)

	static void bruteForceSol(String str) {
		int maxCount = Integer.MIN_VALUE;
		String longestP = "";
		for (int i = 0; i < str.length(); ++i) {
			for (int j = i; j <= str.length(); ++j) {
				String sub = str.substring(i, j);
				if (isPalindrome(sub) && sub.length() > maxCount) {
					maxCount = sub.length();
					longestP = sub;
				}
			}
		}
		System.out.println("Brute Force: Longest Palindrom: " + longestP);
	}

	private static boolean isPalindrome(String sub) {
		// TODO Auto-generated method stub
		return false;
	}

	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high + 1));
	}

	// This function prints the longest palindrome substring
	// of str[].
	// It also returns the length of the longest palindrome
	static int longestPalSubstr(String str) {
		int n = str.length(); // get length of input string

		// table[i][j] will be false if substring str[i..j]
		// is not palindrome.
		// Else table[i][j] will be true
		boolean table[][] = new boolean[n][n];

		// All substrings of length 1 are palindromes
		int maxLength = 1;//filling diagonally
		for (int i = 0; i < n; ++i)
			table[i][i] = true;

		// check for sub-string of length 2.
		// iterate entire charset 2 at a time.
		int start = 0;
		for (int i = 0; i < n - 1; ++i) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}

		// k is for string length
		for (int k = 3; k <= n; ++k) {

			// Fix the starting index
			for (int i = 0; i < n - k + 1; ++i) {
				// Get the ending index of substring from
				// starting index i and length k
				int j = i + k - 1; // example for str len k=3, i=0, j=2, ary[0][2]

				// checking for sub-string from ith index to
				// jth index iff str.charAt(i+1) to
				// str.charAt(j-1) is a palindrome
				// check lower left diagonal
				if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;

					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}
			}
		}
		System.out.print("Longest palindrome substring is; ");
		printSubStr(str, start, start + maxLength - 1);

		return maxLength; // return length of LPS
	}

}
