package ary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <b>IDeserve <br>
 * <a href=
 * "https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Given a dictionary of words and a string of characters, find if the string of
 * characters can be broken into individual valid words from the dictionary.
 *
 * @author Saurabh
 */
public class WordBreakProblem {

	private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("arrays", "dynamic", "heaps",
			"IDeserve", "learn", "learning", "linked", "list", "platform", "understand", "understanding", "trees"));

	public static boolean hasValidWords(String words) {

		// Empty string
		if (words == null || words.length() == 0) {
			return true;
		}

		int n = words.length();
		boolean[] validWords = new boolean[n];

		// it will start with first character a
		for (int i = 0; i < n; i++) {
			
			if (dictionary.contains(words.substring(0, i + 1))) { //0
				System.out.println("outer: " + words.substring(0, i + 1));
				validWords[i] = true;//i
				System.out.println("true1");
			}

			System.out.println("outer: " + words.substring(0, i + 1));
			// end of string
			if (validWords[i] == true && (i == n - 1))
				return true;

			if (validWords[i] == true) {

				for (int j = i + 1; j < n; j++) {
					if (dictionary.contains(words.substring(i + 1, j + 1))) {// i+1 is where we left above.
						validWords[j] = true; //j
						System.out.println("true2");
					}
					System.out.println("Inner: " + words.substring(i + 1, j + 1));

					if (j == n - 1 && validWords[j] == true) {
						return true;
					}

				}

			}

		}
		return false;
	}

	public static void main(String[] args) {
		if (hasValidWords("learnunderstandingplatform"))
			System.out.println("true");
		else
			System.out.println("false");
	}
}