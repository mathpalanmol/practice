package problem;

/*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

*
*https://www.youtube.com/watch?v=b6AGUjqIPsA&t=795s    search with minimum edit by vivekanand
*
*Procedure:
*1. Arrange given two string characters in row and column. 'null' will point to first row and column.
*2. if characters match take copy diagonal value to the given cell else take min of adjacent 3 cells and add 1 just 
*remember the direction for which you are taking min. (-->)insert, (down arrow)remove, (horizontal arrow) replace.
*second step is similar to max1square
*/

public class MinimumEdit {

	public static void main(String[] args) {
		/*char[] charrow = { 'c', 'a', 't' };
		char[] charcol = { 'c', 'u', 't' };*/
		char[] charrow = { 'g', 'e', 'e', 'k' };
		char[] charcol = { 'g', 'e', 's', 'e', 'k' };
		int[][] ary = new int[charrow.length + 1][charcol.length + 1];
		minEdit(charrow, charcol, ary);
	}

	private static void minEdit(char[] charrow, char[] charcol, int[][] ary) {
		// populate first row and column together
		// first row 0,1,2 --> ary length -1
		// first col 0,1,2 --> ary lenght -1
		// first charrow, charcol will be considered as null
		// for first cell to achive null from null cell value should be '0'.
		for (int i = 0; i < ary.length; i++) {
			ary[i][0] = i;
			ary[0][i] = i;
		}
		for (int i = 1; i < ary.length; i++) {
			for (int j = 1; j < ary[0].length; j++) {
				if (charrow[i - 1] == charcol[j - 1]) {// if both are same just exclude both. no amendments.
					ary[i][j] = ary[i - 1][j - 1];// upper-left-diagonal
				} else {// below logic is the same for maxsquare1 question
					int value = findMin(ary[i - 1][j], ary[i - 1][j - 1], ary[i][j - 1]); // up, left-diagonal, left
					ary[i][j] = value+1;
				}
			}
		}
		print(ary);

	}
	
	public static void print(int[][] ary2d) {
		for (int[] ary : ary2d) {
			for (int val : ary) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	private static int findMin(int i, int j, int k) {
		return Math.min(i, Math.min(j, k));
	}

}
