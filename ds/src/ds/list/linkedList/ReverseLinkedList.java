package ds.list.linkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Link start = getLinkedList();
		head = start;
		print(start);
		reverse(null, start);
		print(head);
	}

	static Link head = null;

	// mine
	private static Link reverse(Link start) {
		if (start == null) {
			head.next = null;
			return null;
		}
		Link current = reverse(start.next);
		if (current != null)
			current.next = start;
		else
			head = start;
		return start;
	}

	private static void print(Link start) {
		Link current = start;
		while (current != null) {
			System.out.print(current.key + " ");
			current = current.next;
		}
		System.out.println("\n\n");
	}

	static Link reverse(Link pre, Link current) {
		if (current == null) {
			return null;
		}
		Link temp = current.next;
		current.next = pre;
		pre = current;
		Link link = reverse(pre, temp);
		if (link == null) {
			head = temp;
		}
		return head;
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

		Link(int key) {
			this.key = key;
		}
	}

}
