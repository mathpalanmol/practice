package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class javaCompare {
	static ArrayList<Test> list = new ArrayList<Test>();

	public static void main(String[] args) {

		list.add(new Test(2));
		list.add(new Test(1));
		list.add(new Test(3));
		list.add(new Test(0));
		Collections.sort(list, new Comparator<Test>() {

			@Override
			public int compare(Test o1, Test o2) {
				System.out.println("o1.val: " + o1.val + " o2.val: " + o2.val + " diff: " + (o1.val - o2.val));
				for (Test t : list) {
					System.out.println(t.val);
				}
				return o1.val - o2.val;
			}

		});
		System.out.println("final Iteration");
		for (Test t : list) {
			System.out.println(t.val);
		}
		
		System.out.println("\n\n" + "ab".compareTo("ab"));

	}

	class Comptr implements Comparator<Test> {

		@Override
		public int compare(Test o1, Test o2) {
			System.out.println("o1.val: " + o1.val + " o2.val: " + o2.val + " diff: " + (o1.val - o2.val));

			return o1.val - o2.val; // Increasing order
		}

	}

}

class Test {
	int val;

	public Test(int val) {
		super();
		this.val = val;
	}

}
