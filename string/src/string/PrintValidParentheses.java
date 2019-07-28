package string;

//Approach:
//
//
//Recursion is the key here.
//N pair means n open and n closed parenthesis..
//Select the open parentheses, add it to the result string and reduce its count and make a recursive call.
//Select the close parentheses, add it to the result string and reduce its count and make a recursive call.
//To print only valid parentheses, make sure at any given point of time, close parentheses count is not less 
//that open parentheses count because it means close parentheses has been printed with its respective open parentheses.

//Given n=2
//
//Output:
//(())
//()()

public class PrintValidParentheses {

	public static void Validparentheses(int openP, int closeP, String string) {
		if (openP == 0 && closeP == 0) // mean all opening and closing in
										// string,
										// print it
			System.out.println(string);
		if (openP > closeP) // means closing parentheses is more than open ones
			return;
		if (openP > 0)
			Validparentheses(openP - 1, closeP, string + "("); // put ( and
																// reduce
																// the count by
																// 1
		if (closeP > 0)
			Validparentheses(openP, closeP - 1, string + ")"); // put ) and
																// reduce
																// the count by
																// 1
	}

	public static void printParentheses(int n) {
		Validparentheses(n, n, "");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2; //string len will be 4, n=2 is two pairs
		printParentheses(n);
	}
}
