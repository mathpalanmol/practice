package test;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
//		int i = (1<<2)-1;
//		System.out.println(i);
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		if(q.contains(2)) {
			q.remove(2);
		}
		
		q.addFirst(0);
		q.addLast(3);
		for(int val : q) {
			System.out.println(val);
		}
		
	}

}
