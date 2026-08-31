package ds.list.linkedList;


// merge point and intersection point is same.
public class MergePoint {
	public static void main(String[] args) {
		Link link = getMergePoint(getLinkedList1(), getLinkedList2());
		if (link == null)
			System.out.println("No merging point found.");
		else
			System.out.println("Merge Point: " + link.key);
	}

	static Link getMergePoint(Link link1, Link link2) {
		int len1 = getLength(link1);
		int len2 = getLength(link2);
		int diff = Math.abs(len1 - len2);
		if (len1 > len2) {
			while (diff != 0) {
				link1 = link1.next;
				diff--;
			}
		} else if (len2 > len1) {
			while (diff != 0) {
				link2 = link2.next;
				diff--;
			}
		}
		// null check for NO merging point.
		while (link1 != null && link2 != null && link1.key != link2.key) {
			link1 = link1.next;
			link2 = link2.next;
		}

		return link1; // or link2
	}

	private static int getLength(Link current) {
		int len = 0;
		while (current != null) {
			current = current.next;
			len++;
		}
		return len;
	}

	private static Link getLinkedList1() {
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

	private static Link getLinkedList2() {
		Link l1 = new Link(11);
		Link l2 = new Link(22);
		Link l3 = new Link(13);
		Link l4 = new Link(14);
		Link l5 = new Link(15);
		Link l6 = new Link(16);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

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
