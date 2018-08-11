package ary;


// Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.(Case Sensitivity exists) Examples : The quick brown fox jumps over the lazy dog is a Pangram [Contains all the characters from 'a' to 'z'] The quick brown fox jumps over the dog is not a Pangram [Doesn't contains all the characters from 'a' to 'z', as 'l', 'z', 'y' are missing] The quick brown fox jumps over the lazy dog //string true //output The quick brown fox jumps over the dog //string fals

public class Pangram {

	public static void main(String[] args) {
		String input = "The quick brown fox jumps over the lazy dog";
		boolean pangram = checkPangram(input);
		System.out.println("Pangram: " + pangram);
	}

	private static boolean checkPangram(String input) {
		input = input.toUpperCase();
		char[] chAry = input.toCharArray();
		boolean[] bAry = new boolean[26];
		for (char ch : chAry) {
			if (ch == ' ')
				continue;
			else {
				int index = ((int) ch) - 65;
				bAry[index] = true;
			}
		}
		for (boolean value : bAry) {
			if (!value)
				return false;
		}
		return true;
	}

}
