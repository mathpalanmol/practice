package test;

import java.util.Stack;
/* Insert element in stack after x elements using recursion
 * Or we can make use of an extra stack.
 * */
public class StackRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(4);
		stack.add(6);
		stack.add(8);
		stack.add(10);
		insert(stack, 3, 9, 0);
		System.out.println("After insert");
		while (!stack.isEmpty())
			System.out.println(stack.pop());

	}

	public static void insert(Stack<Integer> stack, int elementCount, int value, int count) {
		if (elementCount == count) {
			stack.push(value);
			return;
		}
		int popValue = stack.pop();
		insert(stack, elementCount, value, ++count);
		stack.push(popValue);
	}

}
