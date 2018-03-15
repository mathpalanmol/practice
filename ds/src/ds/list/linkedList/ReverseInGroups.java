package ds.list.linkedList;

//
//Example:
//Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
//Output:  3->2->1->6->5->4->8->7->NULL. 

public class ReverseInGroups {


	public static void main(String[] args) {
		Link start = getLinkedList();
		print(start);
		Link rstart = reverseKLinks(start, 3);
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

	private static Link reverseKLinks(Link start, int k) {
		if(start == null)
			return null;
		Link current = start;
		int count = 0;
		Link pre = null;
		//this loop should run three times as we have to get reach till 4 to get next ,ie 1,2,3,4
		while(current != null && count < k) {
			Link temp = current.next;
			current.next = pre;
			pre = current;
			current = temp;
			count++;
		}
		if(start != null)
		start.next = current;
		
		if(current!=null) {
			start.next= reverseKLinks(current, k);
		}
		
		return pre;
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
