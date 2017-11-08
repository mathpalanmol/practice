package patternmatch;

//knoth-Moris O(m+n) kMP
//create prefix/suffix tree
// rules:- 1. create an array size equal to pattern length. initialize first index at zero. single charter can't have suffix or prefix
//take two pointer i and j in pattern. j start with 0 and i start with 1. 
// check if value in ith and jth index is same, if yes value = j+1; 
//else take the previous index char in pattern and check it's value in pre/suf array. take this value and 
// get the char at this index and match it, if it matches; value = char index + 1; if no match follow the same procedure until reaches zero.
public class KMP {
    // get the partial match array for the pattern string
	// Go through the text array one by one. (Note we'll never look back in the text array). Pointer is i.
	// K is a pointer to pattern array
	// if char of both text and pattern match increment both counter
	// in unmatched condition: take the index of previous character in pattern array and fetch it's value in partial match ary
	// get the character at this newly fetch index from pattern array . match this character with ith index character.
	// if it didn't match repeat above two steps. if it reaches to k==0 and still it didn't match just increment i. (i.e. skip it and move to next character in text array)
	public int find(String text, String pattern) {
		int[] s_p_ary = createSufPreary(pattern);
		char[] p_ary = pattern.toCharArray();
		char[] textAry = text.toCharArray();
		int k = 0;//pattern pointer
		for (int i = 0; i < textAry.length ;) {
			if (textAry[i] == p_ary[k]) {
				if (k == (p_ary.length - 1))
					return i - k;

				i++;
				k++;
			} else {
				if (k == 0) { // not matched as well
					i++;// move to next character in given text
				} else {
					int newIndex = s_p_ary[k - 1];// get new ponter from partial match array
					k = newIndex;// update the pattern pointer
				}
			}
		}
		return -1;
	}

	// partial match array
	// create 2 arrays: 1 is array with pattern chars patAry and 2 is pattern match ary ie. int[] ary containing count
	// initialze 0th index of ary(pattern match) with 0;//it's default value of int ary so no need to do it programmatically 
	// take two pointers i and j in pattern array
	// start j with 0 index and i with 1 index in pattern array. (Note: we'll never decrement i in any case)
	//  Every char at jth index will be matched with ith index in patAry
	//If value at i and j index matches, update ary[i]=j+1 and increment both the pointers.
	// In unmatched condition: take the index of previous character(i-1) in pattern array and fetch it's value in partial match ary ie. ary, this value will become our new j
	// get the character at this newly fetch index from pattern array . match this character with ith index character.
	// if it didn't match repeat above two steps and if reaches to j==0, update ary[i] = 0;
	// if there is a match do as usual update ary[i] = j+1;and increment both the pointers
	private static int[] createSufPreary(String pattern) {
		char[] patAry = pattern.toCharArray();//pattern array
		int[] ary = new int[pattern.length()];//pattern match array
		ary[0] = 0;//initialze first value as 0; although not required programmatically 
		int j = 0;
		int i = 1;
		while (i < patAry.length) {//1 to n characters
			if (patAry[j] == patAry[i]) {//match
				ary[i] = j + 1;//update pattern match ary with j+1; j is the index of pattern ary
				i++;//increment i
				j++;//increment j
			} else {//not match
				if (j == 0) { // y this. consider pattern as 'abc' j=0 and i=2 or'acc'
					ary[i] = j;// ary[i] = 0; fair enough
					i++; // increment i leaving j at index 0
				}
				int x = i; // retain ith location for further calucation
				while (j != 0) {//unitl j!=0
					int newcandidateindex = ary[x - 1];//finding new value for j to match with i
					if (patAry[newcandidateindex] == patAry[i]) {//match
						ary[i] = newcandidateindex + 1; // same as j+1
						j = newcandidateindex;// j is assigned to it's new value
						i++;//increment  - match condition
						j++;//increment  - match condition
						break;// break and continue with new i and this j
					}
					x = newcandidateindex;
					j = x;
				}
			}
		}
		return ary;
	}

	public static String reverse(String str) {
		if (str.length() == 0)
			return "";
		return reverse(str.substring(1)) + str.substring(0, 1);
	}

	// Create shortest palindrom by adding least no of characters at the start
	// of given string
	// create new string by reversing the string and append it at the end of given string a
	// get partial match array and fetch it's last indexed value.
	// this value tell us about the length of similar string present in the new string; e.g. "ababbaba" for last charachter a count will be 3 "aba"..."aba"   
	// remove this common part for the reverse string and add the remaining charachter at the start of input string.
	public String genSortestPalindrom(String str) {
		String revStr = reverse(str);
		String longestPalindrom = str + revStr;
		int[] pmAry = createSufPreary(longestPalindrom);
		System.out.println("Printing partial array");
		for(int value : pmAry)
			System.out.print(value + " ");
		int value = pmAry[pmAry.length - 1];
		return revStr.substring(0, revStr.length() - value) + str;
	}

	public static void main(String[] args) {
		KMP ref = new KMP();
//		int index = ref.find("my name is anmol mathpal", "anmol");
//		if (index != -1)
//			System.out.println("String found at Index: " + index);
//		else
//			System.out.println("String not found.");
		int[] ary  = createSufPreary("aabaabaaab");
		for(int value : ary){
			System.out.println(value);
		}

		System.out.println("Generate Sortest Palindrom for a Given input string: ");
		System.out.println(ref.genSortestPalindrom("aba"));
	}

}
