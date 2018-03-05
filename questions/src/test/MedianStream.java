package test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianStream {

	static NumberFormat formatter = new DecimalFormat("#0.00");
	
	
	static void median(String a[], int x[]) {
		double effMedian = 0.0;
		formatter.setMaximumFractionDigits(1);
		PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < a.length; i++) {
			boolean flag = true;
			if (a[i].equals("r"))
				flag = remove(minq, maxq, x[i]);
			else if (a[i].equals("a"))
				add(minq, maxq, x[i], effMedian);
			if (flag) {
				Double median = findMedian(minq, maxq);
				effMedian = median;

				if ((median.doubleValue() - median.intValue()) != 0.0f) {
					
					System.out.println(formatter.format(median));

				} else
					System.out.println(median.intValue());
			} else
				System.out.println("Wrong!");

		}
	}

	private static double findMedian(PriorityQueue<Integer> minq, PriorityQueue<Integer> maxq) {
		if (maxq.size() == 0 && minq.size() == 0)
			return 0.0;
		if (minq.isEmpty())
			return maxq.peek();
		if (maxq.isEmpty())
			return minq.peek();
		if (maxq.size() == minq.size()) {
			double val = ((double) maxq.peek() + (double) minq.peek()) / 2;
			return val;
		} else if (minq.size() > maxq.size()) {
			return minq.peek();
		}
		return maxq.peek();
	}

	private static void add(PriorityQueue<Integer> minq, PriorityQueue<Integer> maxq, int value, double effMedian) {
//		Double median = findMedian(minq, maxq);
		if (value < effMedian)
			maxq.offer(value);
		else
			minq.offer(value);
		if (maxq.size() - minq.size() == 0) {
			return;
		}
		if (maxq.size() - minq.size() > 1) {
			minq.offer(maxq.poll());
			return;
		}
		if (minq.size() - maxq.size() > 1) {
			maxq.offer(minq.poll());
			return;
		}

	}

	private static boolean remove(PriorityQueue<Integer> minq, PriorityQueue<Integer> maxq, int value) {
		if (maxq.isEmpty() && minq.isEmpty()) {
			return false;
		}
		if (maxq.contains(value)) {
			maxq.remove(value);
		} else if (minq.contains(value))
			minq.remove(value);
		else {
			// System.out.println("Wrong!");
			return false;
		}
		if (maxq.isEmpty() && minq.isEmpty()) {
			return false;
		}
		if (maxq.size() - minq.size() > 1) {
			minq.offer(maxq.poll());
			return true;
		}
		if (minq.size() - maxq.size() > 1) {
			maxq.offer(minq.poll());
			return true;
		}
		return true;
	}

	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		
		
		Scanner in = new Scanner(System.in);

		int N;
		N = in.nextInt();

		String s[] = new String[N];
		int x[] = new int[N];

		for (int i = 0; i < N; i++) {
			s[i] = in.next();
			x[i] = in.nextInt();
		}

		median(s, x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("totalTime: " + totalTime);
	}

}
