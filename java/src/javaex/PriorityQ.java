package javaex;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ {

	public static void main(String[] args) {
		// To get MAX first : Reverse the default order
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(4);
		pq.add(7);
		pq.add(2);
		pq.add(5);
		pq.add(3);
		while (pq.size() != 0) {
			System.out.println(pq.poll());
		}
		System.out.println("\n\n\n\n" + "Default:");
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();// min heap as default
		q.add(4);
		q.add(7);
		q.add(2);
		q.add(5);
		q.add(3);
		while (q.size() != 0) {
			System.out.println(q.poll());
		}

		System.out.println();
		// To get MIN first
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(new Comparator<Integer>() {

			public int compare(Integer i, Integer j) {
				return i - j;
			}

		});
		pq1.add(4);
		pq1.add(3);
		pq1.add(5);

		while (pq1.size() != 0) {
			System.out.println(pq1.poll());
		}

	}

}
