package test;

import java.util.Scanner;
import java.util.Stack;

public class CrazyStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for (int index = 0; index < count; index++) {
			String operation = scan.next();
			operation += scan.nextLine();
			String[] opAry = operation.split(" ");
			if (opAry.length == 2) {
				stack.push(new Integer(opAry[1]));
			} else if (opAry.length == 1) {
				if(!stack.isEmpty())
				stack.pop();
			} else {
				Integer elementcount = new Integer(opAry[1]);//count
				Integer element = new Integer(opAry[2]);//add
				int len = stack.size();
				for (int i = 0; i < len - elementcount; i++) {
					tempStack.push(stack.pop());
				}
				while(!stack.isEmpty()){
					tempStack.push(stack.pop()+element);
				}
				while (!tempStack.isEmpty()) {
					stack.push(tempStack.pop());
				}
			}
			if(!stack.isEmpty())
			System.out.println(stack.peek());
			else
				System.out.println("EMPTY");
		}

	}
	
	static void superStack(String[] operations) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		for (int index = 0; index < operations.length; index++) {
			String operation = operations[index];
			String[] opAry = operation.split(" ");
			if (opAry.length == 2) {
				stack.push(new Integer(opAry[1]));
			} else if (opAry.length == 1) {
				if(stack.isEmpty()){
					System.out.println("EMPTY");
				}else
				stack.pop();
			} else {
				Integer elementcount = new Integer(opAry[1]);
				Integer element = new Integer(opAry[2]);
				for (int i = 0; i < elementcount; i++) {
					tempStack.push(stack.pop());
				}
				stack.push(element);
				while (!tempStack.isEmpty()) {
					stack.push(tempStack.pop());
				}
			}
			System.out.println(stack.peek());
		}
    }

}
