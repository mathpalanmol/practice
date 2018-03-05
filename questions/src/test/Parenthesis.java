package test;

import java.util.HashMap;
import java.util.Stack;

// [()]{}{[()()]()} --> true
// [(]) --> false
public class Parenthesis {

	public static void main(String[] args) {
		System.out.println(process("[()]{}{[()()]()}".toCharArray()));
		System.out.println(process("[()]".toCharArray()));

	}

	static boolean process(char[] chAry) {
		boolean result = true;
		int len = chAry.length;
		if(len%2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put(')', '(');
		map.put('}', '{');
		for (int i = 0; i < len; i++) {
			String operation = getOperation(chAry[i]);
			result = execute(stack, operation, chAry[i], map);
			if(!result)
				break;
		}
		return result;
	}

	private static boolean execute(Stack<Character> stack, String operation, char ch, HashMap<Character, Character> map) {
		
		if (operation.equals("push"))
			stack.push(ch);
		else {
			if (stack.peek().equals(map.get(ch)))
				stack.pop();
			else
				return false;
		}
		return true;
	}

	private static String getOperation(char c) {
		switch (c) {
		case '[':
		case '(':
		case '{':
			return "push";
		default:
			return "pop";
		}
	}

}
