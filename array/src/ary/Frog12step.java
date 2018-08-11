package ary;


//Frog can jump 1 or 2 steps. find no of ways to reach to go to n steps. 
// Frog can start either by taking one step or two step
public class Frog12step {
	int count;

	public void walk(int dist) {
		if (dist == 0) {
			count++;
		} else if (dist < 0)
			return;
		else {
			walk(dist - 1);
			// dist--; // include this if you want to start with 1 always. logic
			// we are decrementing the distance after moving.
			// ex: dist = 3; after returning from all walk(dist - 1) iteration
			// dist will still be 3 for walk(dist - 1) iteration.
			// vise-versa for 2 and 1.
			walk(dist - 2);
//			walk(dist - 3);
		}
	}
// initialze counter with any arbitary value
	public void print(int[] ary, int dist, int index, int counter) {

		if (dist == 0) {
			for (int i = 0; i < index; i++)
				System.out.print(ary[i]);
			System.out.println();
			count++;
			return;
		} else if (dist < 0)
			return;
		else {

			print(ary, dist - 1, index + 1, ary[index] = 1);// ary[index] = 1;
															// bit tricky but we
															// want to update
															// the array same
					
			// time; consider
															// the case if after
															// decrementing 1 or
															// 2 the sum is zero
															// and if this
															// statement is not
															// there, it will
															// print the array
															// without
															// inserting/updating
															// the value at
															// previous index

			print(ary, dist - 2, index + 1, ary[index] = 2);
		}
	}

	public static void main(String[] args) {
		Frog12step ref = new Frog12step();
	    ref.walk(4);
		int[] ary = new int[5];
		ref.print(ary, 5, 0, -1);
		System.out.println("No of ways: " + ref.count);
	}

}
