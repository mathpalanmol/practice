package ary;


import java.util.Stack;

public class Bracket {

//	public static boolean isBalanced(String expression) {
//		char[] ary = expression.toCharArray();
//		for(int i=0; i< ary.length-1; i++){
//			if(ary[i] == '{' {}
//		}
//		return false;
//	}

	public static void main(String[] args) {
		System.out.println(isParenthesisMatch("{[]}")); // {}[]()
		System.out.println(isParenthesisMatch("{}[]()"));

	}
	
	
	public static boolean isParenthesisMatch(String str) {

	    Stack<Character> stack = new Stack<Character>();

	    char c;
	    for(int i=0; i < str.length(); i++) {
	        c = str.charAt(i);

	        if(c == '(')
	            stack.push(c);
	        else if(c == '{')
	            stack.push(c);
	        else if(c == '[')
	            stack.push(c);
	        else if(c == ')')
	            if(stack.empty())
	                return false;
	            else if(stack.peek() == '(')
	                stack.pop();
	            else
	                return false;
	        else if(c == '}')
	            if(stack.empty())
	                return false;
	            else if(stack.peek() == '{')
	                stack.pop();
	            else
	                return false;
	        else if(c == ']')
	            if(stack.empty())
	                return false;
	            else if(stack.peek() == '[')
	                stack.pop();
	            else
	                return false;
	    }
	    return stack.empty();
	}
}
