package ds.stack;

public class CStack {

	// Stack using array
	static int[] intAry = new int[5];
	static int count = 0;

	public int push(int item) {
		int size = intAry.length;
		if (count >= size)
			return -1;
		intAry[count] = item;
		count++;
		return item;
	}

	public int pop() {
		System.out.println("Popping");
		if (count == 0)
			return -1;
		int delItem = intAry[count - 1];
		count--;
		return delItem;
	}

	// print
	public static void print() {
		System.out.println("Printing");
		for (int i=0; i<count; i++)
			System.out.println(intAry[i]);
	}

	public static void main(String[] args) {
		CStack stack = new CStack();
		for (int i = 0; i < 7; i++) {
			int result = stack.push(i);
			if (result != -1)
				System.out.println("Insertion passed for item " + i);
			else
				System.out.println("Insertion failed for item " + i);
		}

		print();
		stack.pop();
		print();

	}

}
