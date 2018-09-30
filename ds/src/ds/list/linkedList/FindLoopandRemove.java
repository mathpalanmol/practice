package ds.list.linkedList;

//m => length from starting of list to starting of loop (i.e 1-2-3-4)
//l => length of loop (i.e. 4-5-6-7-8-9)
//k => length between starting of loop to meeting point (i.e. 4-5-6-7)
//m + q(l) + k = 2 * ( m + p(l) +k )
//or, m + k = q(l) - p(l)
//or, m + k = (q-p) l
//or, m = (q-p) l - k

// If slowPtr starts from beginning of list and travels "m" length then, it will reach to starting point of loop.

public class FindLoopandRemove {
	
	public static void main(String[] args) {
		Link list = getLinkedList();
		boolean loop = checkLoop(list);
		System.out.println(loop);
		if(loop) {
			Link link = returnLoopStart(list);
			System.out.println("Loop starts at: " + link.key);
			removeLoop(link);
		}
	}
	private static void removeLoop(Link link) {
		Link start = link; // start loop
		Link current = start.next;
		Link pre = start;
		while(current != start) {
	          pre = current;
	          current = current.next;
		}
		pre.next = null; // remove the loop
	}
	private static boolean checkLoop(Link current) {
		Link slow = current;
		Link fast = current;
		// in while we are checking for null for each and every element.
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(slow == null || fast == null)
				return false;
			if(slow == fast)
				return true;
		}
		return true;
		
	}
	private static Link returnLoopStart(Link current) {
		Link slow = current;
		Link fast = current;
		while(true) { // loop is confirmed by calling method so no need for null check inside the loop
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		slow = current;
		while(slow.key != fast.key) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	private static Link getLinkedList() {
		Link l1 = new Link(1);
		Link l2 = new Link(2);
		Link l3 = new Link(3);
		Link l4 = new Link(4);
		Link l5 = new Link(5);
		Link l6 = new Link(6);
		Link l7 = new Link(7);
		Link l8 = new Link(8);
		Link l9 = new Link(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l4; // loop exist
	
		return l1;
	}

	static class Link {
		int key;
		Link next;

		public Link(int key) {
			this.key = key;
		}
	}

}
