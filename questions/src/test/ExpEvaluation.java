package test;

import java.util.Stack;

//Expression evaluates from right to left in computer.
public class ExpEvaluation {

	public static void main(String[] args) {
		System.out.println(evaluate("10 +  2 * 6"));
		// System.out.println(evaluate("100 * 2 + 12"));
		// System.out.println(evaluate("100 * ( 2 + 12 )"));
		// System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));

	}

	public static int evaluate(String exp) {
		char[] chAry = exp.toCharArray();
		Stack<Character> operator = new Stack<Character>();
		Stack<Integer> operands = new Stack<Integer>();
		for (int i = 0; i < chAry.length; i++) {
			if (chAry[i] == ' ')
				continue;

			if (chAry[i] >= '0' && chAry[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				while (i < chAry.length && chAry[i] >= '0' && chAry[i] <= '9') {
					sb.append(chAry[i]);
                    i++;
				}
				int no = Integer.parseInt(sb.toString());
				operands.push(no);
				continue;
			}

			if (chAry[i] == '(') {
				operator.push(chAry[i]);
				continue;
			}

			if (chAry[i] == '+' || chAry[i] == '*' || chAry[i] == '/' || chAry[i] == '-') {
				if (operator.isEmpty())
					operator.push(chAry[i]);
				else {
					while (!operator.isEmpty()) {
						// if current operator has higher precedence
						if (!checkPrecedence(chAry[i], operator.peek())) {
							int value = calculate(operator.pop(), operands.pop(), operands.pop());
							operands.push(value);
						} else {
							// if current operator has lower precedence
							operator.push(chAry[i]);
							break;
						}
					}
				}
			}
			if (chAry[i] == ')') {
				while (operator.peek() != '(') {
					int value = calculate(operator.pop(), operands.pop(), operands.pop());
					operands.push(value);
				}
				operator.pop();
			}

		}
		while (!operator.isEmpty()) {
			int value = calculate(operator.pop(), operands.pop(), operands.pop());
			operands.push(value);
		}
		return operands.peek();
	}

	private static int calculate(Character ch, Integer v1, Integer v2) {
		switch (ch) {
		case '+':
			return v1 + v2;
		case '-':
			return v1 - v2;
		case '*':
			return v1 * v2;
		case '/':
			return v1 / v2;
		}
		return -1;
	}

	static boolean checkPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return true;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return true;
		return false;

	}

}
