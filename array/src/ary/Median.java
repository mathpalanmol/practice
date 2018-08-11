package ary;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

	PriorityQueue<Float> min = new PriorityQueue<Float>(); // min heap
	PriorityQueue<Float> max = new PriorityQueue<Float>(new Comparator<Float>() { // max heap

		@Override
		public int compare(Float o1, Float o2) {

			return (int) (o2 - o1); // Reverse order
		}

	}); // new Comparator<Integer>() {Collections.reverseOrder;

	// Every time while inserting, compare key with effective median; all keys
	// greater than effective median should lie in the max heap.
	void addItems(Float key) {
		if (max.size() == 0) { // put first element in max heap. one time job
			max.add(key);
			return;
		}
		
		Float effMedian = getEffectiveMedian();
		if (key < effMedian)
			max.add(key);
		else
			min.add(key);
		rebalance(min, max);
	}

	private void rebalance(PriorityQueue<Float> min, PriorityQueue<Float> max) {
		if (min.size() == max.size() || Math.abs(min.size() - max.size()) <= 1)
			return;
		if (min.size() > max.size())
			max.add(min.poll());
		else
			min.add(max.poll());

	}

	Float getEffectiveMedian() {
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
		 float[] ary = {2,1};
//		int[] ary = { -2,-2,-1 };
		Median ref = new Median();
		for (float value : ary) {
			ref.addItems(value);
		}
		float median = ref.getEffectiveMedian();
		System.out.println("Median: " + median);
	}

}
