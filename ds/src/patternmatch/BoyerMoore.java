package patternmatch;
//Boyer Moore algorithm also preprocesses the pattern.

//Boyer Moore is a combination of following two approaches.
//1) Bad Character Heuristic
//2) Good Suffix Heuristic 
// Bad index table is key value pair, where key is the character 
//in the pattern and value is the index. 
//This table doesn't contain dublicate letter. 
//So if there is any dubplicate character it's value get's updated with newly
//calculated value of that character. 
//Formula is index = length of pattern-index of character in pattern-1. 
//Note: For the last character the value will be the length of array and for null character value is again equal to length.

public class BoyerMoore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
