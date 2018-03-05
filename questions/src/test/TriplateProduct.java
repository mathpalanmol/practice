package test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Maximum product of a triplet
//5
//10 3 5 6 20
//Output: 1200
//5
//-10 -3 -5 -6 -20
//Output: -90
//5
//1 -4 3 -6 7 0
//Output: 168
public class TriplateProduct {
	public static void main(String[] args) {
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}

		});
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		for (int i = 0; i < len; i++) {
			int value = scan.nextInt();
			minQ.offer(value);
			maxQ.offer(value);
		}

		int[] ary = new int[5];
		int productMax = 1;
		int maxValue = maxQ.peek();
		for (int i = 0; i < 3; i++) {
			int value = maxQ.poll();
			productMax = productMax * value;
		}
		int productMin = 1;
		for (int i = 0; i < 2; i++) {
			int value = minQ.poll();
			productMin = productMin * value;
		}
		productMin = productMin * maxValue;
		int result = productMax > productMin ? productMax : productMin;
		System.out.println(result);
	}

}