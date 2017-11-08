package test;
//10
//1 42
//2
//1 14
//3
//1 28
//3
//1 60
//1 78
//2
//2
import java.util.Scanner;
import java.util.Stack;
//10 - no of operations
//1 42 - 1 is push
//2    - 2 is pop
//1 14
//3    - 3 print top element(in queue fashion FIFO)
//1 28
//3
//1 60
//1 78
//2
//2
public class StackToQ {

	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Scanner scan = new Scanner(System.in);
		int operations = scan.nextInt();
		for (int i = 0; i < operations; i++) {
			String str = scan.next();
			str = str + scan.nextLine();
			String[] strAry = str.split(" ");
			if(strAry.length == 2){
				stack1.push(Integer.parseInt(strAry[1]));
			}else{
				if(strAry.length == 1){
					int input = Integer.parseInt(strAry[0]);
					if(input == 2){//pop
						if(!stack2.isEmpty())
							stack2.pop();
						else{
							while(!stack1.isEmpty()){
								stack2.push(stack1.pop());
							}
							stack2.pop();
						}
					}
					if(input == 3)
						if(!stack2.isEmpty())
							System.out.println(stack2.peek());
						else{
							while(!stack1.isEmpty()){
								stack2.push(stack1.pop());
							}
							System.out.println(stack2.peek());
						}
				}
			}
		}

	}

}
