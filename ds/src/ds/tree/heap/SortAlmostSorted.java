package ds.tree.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSorted {

	public static void main(String[] args) {
		Integer[] ary = { 1, 2, 7, 9, 3, 6 };
		sort(ary, 3);

	}

	private static void sort(Integer[] ary, int k) {
		List<Integer> asList = Arrays.asList(ary);
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(asList.subList(0, k + 1));
		int index = 0;
		for (Integer i = k + 1; i < ary.length; i++) {
			ary[index++] = q.poll();
			q.offer(asList.get(i));
		}

		while (q.size() != 0) {
			ary[index++] = q.poll();
		}
		
		System.out.println(Arrays.asList(ary).toString());

	}

}
