package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test4{
	public static void main(String[] args) {
		
	
	System.out.println(isParenthesisMatch("{[}]}"));
	}
	
	public static boolean isParenthesisMatch(String str) {
	    if (str.charAt(0) == '{')
	        return false;

	    Stack<Character> stack = new Stack<Character>();

	    char c;
	    for(int i=0; i < str.length(); i++) {
	        c = str.charAt(i);

	        if(c == '(')
	            stack.push(c);
	        else if(c == '{')
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
	    }
	    return stack.empty();
	}

//public static boolean isParenthesisMatch(String str) {
//    Stack<Character> stack = new Stack<Character>();
//
//    char c;
//    for(int i=0; i < str.length(); i++) {
//        c = str.charAt(i);
//
//        if(c == '{')
//            return false;
//
//        if(c == '(')
//            stack.push(c);
//
//        if(c == '{') {
//            stack.push(c);
//            if(c == '}')
//                if(stack.empty())
//                    return false;
//                else if(stack.peek() == '{')
//                    stack.pop();
//        }
//        else if(c == ')')
//            if(stack.empty())
//                return false;
//            else if(stack.peek() == '(')
//                    stack.pop();
//                else
//                    return false;
//        }
//        return stack.empty();
//}
} 
