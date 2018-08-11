package ds.list.linkedList;
//Example:
//Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
//Output:   3->2->1->4->5->6->9->8->7->NULL. 

public class ReverseKAlernateNodes {

	public static void main(String[] args) {
		Link start = getLinkedList();
		print(start);
		Link rstart = reverseKLinks(start, 2);
	    print(rstart);

	}

	private static void print(Link start) {
		Link current = start;
		while(current != null) {
			System.out.print(current.key + " ");
			current = current.next;
		}
		System.out.println("\n\n");
	}
//return pre always
	private static Link reverseKLinks(Link start, int k) {
		if(start == null)
			return null;
		Link current = start;
		int count = 0;
		Link pre = null;
		// This loop should run three times as we have to get reach till 4 ,ie 1,2,3,4: 
		// 4 is current.
		while(current != null && count < k) {
			Link temp = current.next;
			current.next = pre;
			pre = current;
			current = temp;
			count++;
		}
		if(start != null)
		start.next = current;
		
		count = 0;
		//this loop should run two times .. ie. k-1 because it has to reach 4,5,6
		//6should be current to perform recursion call
		while(current != null && count < k-1) {
			current = current.next;
			count++;
		}
		if(current!=null) {
			current.next= reverseKLinks(current.next, k);
		}
		
		return pre;//imp
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
		l8.next = l9;
	
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
