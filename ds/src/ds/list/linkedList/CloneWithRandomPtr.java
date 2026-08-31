package ds.list.linkedList;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class CloneWithRandomPtr {
	static LinkedHashMap<Link, Link> map = new LinkedHashMap<Link, Link>();

	// map key: orignal link ; value: clone link [created with next pointer and all
	// values contain rdptr as null]

	public static void main(String[] args) {
		Link listwithRandomPtr = getLinkedList();
		print(listwithRandomPtr);
		Link clonedList = clone(listwithRandomPtr);
		print(clonedList);
	}

	private static Link clone(Link listwithRandomPtr) {
		Link listnextptr = createListwithnextPointer(listwithRandomPtr);
		Link listnextptrHead = listnextptr;
		print(listnextptr);
		for (Entry<Link, Link> entry : map.entrySet()) {// to update random pointer
			Link orignal = entry.getKey();
			Link orignalRptr = orignal.rdPtr;
			Link rptr = map.get(orignalRptr);
			listnextptr.rdPtr = rptr;
			listnextptr = listnextptr.next;
		}
		return listnextptrHead;
	}
    // create newList using next pointer
	// populate map; Key: orignal LinkedList node, value: newNode
	private static Link createListwithnextPointer(Link listwithRandomPtr) {
		Link head = null;
		Link current = null;
		while (listwithRandomPtr != null) {
			Link newLink = new Link(listwithRandomPtr.key);
			if (head == null) {
				head = newLink;
				current = head;
				map.put(listwithRandomPtr, newLink);
				listwithRandomPtr = listwithRandomPtr.next;
				continue;
			} else
				current.next = newLink;

			map.put(listwithRandomPtr, newLink);
			current = current.next;
			listwithRandomPtr = listwithRandomPtr.next;
		}

		return head;
	}

	private static void print(Link start) {
		Link current = start;
		while (current != null) {
			System.out.print(current.key + " ");
			current = current.next;
		}
		System.out.println("\n\n");
	}

	private static Link getLinkedList() {
		Link l1 = new Link(1);
		Link l2 = new Link(2);
		Link l3 = new Link(3);
		Link l4 = new Link(4);
		Link l5 = new Link(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		l1.rdPtr = l4;
		l2.rdPtr = l5;
		l3.rdPtr = l5;
		l4.rdPtr = l1;
		l5.rdPtr = l3;

		return l1;
	}

	static class Link {
		int key;
		Link next;
		Link rdPtr; // random Pointer

		public Link(int key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "Link [key=" + key + ", next=" + next + ", rdPtr=" + rdPtr + "]";
		}

	}

}
