package questions.array;

import java.util.Arrays;

// Given two strings S1 and S2. Find the longest common subsequence between S1 and S2. 
// Example: Input- S1 = "ACBEA" S2 = "ADCA"  Output- "ACA
// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
// For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. 
// So a string of length n has 2^n different possible subsequences.

// It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

public class LCS {

	int find(String str1, String str2) {
		char[] ary1 = str1.toCharArray();
		char[] ary2 = str2.toCharArray();
		int[][] matrix = new int[ary1.length + 1][ary2.length + 1];
		for (int i = 0; i < ary2.length + 1; i++) {
			matrix[0][i] = 0; // populating zero in first row.
		}
		for (int i = 0; i < ary1.length + 1; i++) {
			matrix[i][0] = 0; // populating 0 in first column.
		}

		for (int i = 1; i < ary1.length + 1; i++) {
			for (int j = 1; j < ary2.length + 1; j++) {
				if (ary1[i - 1] == ary2[j - 1])
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				else
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
			}
		}
		print(matrix, ary1, ary2);
		printsequence(matrix, ary1, ary2);
		return matrix[ary1.length][ary2.length];
	}

	public void print(int[][] matrix, char[] ary1, char[] ary2) {
		for (int i = 0; i < ary1.length + 1; i++) {
			for (int j = 0; j < ary2.length + 1; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printsequence(int[][] matrix, char[] ary1, char[] ary2) {
		System.out.println("\n\nPrinting common subsequence of: " + Arrays.toString(ary1) + " and " + Arrays.toString(ary2) + " : " );
		for (int i = 1; i < ary1.length + 1; i++) {
			for (int j = 1; j < ary2.length + 1; j++) {
				if (matrix[i][j] != matrix[i - 1][j]) {
					System.out.print(ary1[i - 1] + " ");
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		LCS ref = new LCS();
		int count = ref.find("ACBEA", "ADCA");
		System.out.println("\n\nLCS Count: " + count);
	}
}
