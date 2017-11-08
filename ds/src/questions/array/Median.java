package questions.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

	PriorityQueue<Integer> min = new PriorityQueue<Integer>(); // min heap
	PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>() { // max heap

		@Override
		public int compare(Integer o1, Integer o2) {

			return o2 - o1; // Reverse order
		}

	}); // new Comparator<Integer>() {Collections.reverseOrder;

	// Every time while inserting, compare key with effective median; all keys
	// greater than effective median should lie in the max heap.
	void addItems(int key) {
		if (max.size() == 0) { // put first element in max heap. one time job
			max.add(key);
			return;
		}
		int effMedian = getEffectiveMedian();
		if (key < effMedian)
			max.add(key);
		else
			min.add(key);
		rebalance(min, max);
	}

	private void rebalance(PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		if (min.size() == max.size() || (Math.abs(min.size() - Math.abs(max.size())) <= 1))
			return;
		if (min.size() > max.size())
			max.add(min.poll());
		else
			min.add(max.poll());

	}

	int getEffectiveMedian() {
		if (min.size() == 0) // max can't be null at this point.
			return max.peek();
		if (max.size() == min.size()) // equal return average of root element values
			return (max.peek() + min.peek()) / 2;
		if (max.size() > min.size()) // return root value of max element
			return max.peek();
		else
			return min.peek();
	}

	public static void main(String[] args) {
		// int[] ary = { 1, 2, 3, 4, 5, 6, 7 };
		// int[] ary = {5,6,3,2,7,4,1};
		int[] ary = { -2,-2,-1 };
		Median ref = new Median();
		for (int value : ary) {
			ref.addItems(value);
		}
		int median = ref.getEffectiveMedian();
		System.out.println("Median: " + median);
	}

}
