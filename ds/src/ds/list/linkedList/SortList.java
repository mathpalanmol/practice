package ds.list.linkedList;

public class SortList {

	public static void main(String[] args) {
		Link start = getLinkedList();
		print(start);
		Link head = mergeSort(start);
		print(head);
	}

	private static void print(Link head) {
		while (head != null) {
			System.out.print(head.key + " ");
			head = head.next;
		}
		System.out.println("\n\n");
	}

	private static Link mergeSort(Link start) {
		if (start == null || start.next == null)
			return start;
		Link middle = getMiddle(start);
		Link nextNode = middle.next;// import step break the link 
		middle.next = null;

		Link left = mergeSort(start); // low to  middle
		Link right = mergeSort(nextNode);//middle to high
		Link head = merge(left, right); //merge = low + high
		return head;

	}

	private static Link merge(Link left, Link right) {
		if (left == null) // both can't be null
			return right;
		if (right == null)
			return left;
		Link head = null;
		if (left.key <= right.key) { // decide head
			head = left;
			left = left.next;// increment it
		} else {
			head = right;
			right = right.next;
		}
		Link current = head;
		while (left != null && right != null) {
			if (left.key <= right.key) {
				current.next = left;
				left = left.next;
			} else {
				current.next = right;
				right = right.next;
			}
			current = current.next; // remember it
		}
		while (left != null) { // should be while
			current.next = left;
			left = left.next;
			current = current.next;
		}
		while (right != null) {
			current.next = right;
			right = right.next;
			current = current.next;
		}

		return head;
	}

	private static Link getMiddle(Link start) {
		if(start == null || start.next == null)
			return null;
		Link slowPtr = start;
		Link fastPtr = start;
        
		while (fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			if(fastPtr == null)
				break;
			slowPtr = slowPtr.next;
			
		}

		return slowPtr;
	}

	private static Link getLinkedList() {
		Link l1 = new Link(1);
		Link l2 = new Link(2);
		Link l3 = new Link(0);
		Link l4 = new Link(5);
		Link l5 = new Link(4);
		Link l6 = new Link(6);
		Link l7 = new Link(9);
		Link l8 = new Link(8);
		Link l9 = new Link(7);
		Link l10 = new Link(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l10;

		return l1;
	}

	static class Link {
		int key;
		Link next;

		Link(int key) {
			this.key = key;
		}
	}

}
