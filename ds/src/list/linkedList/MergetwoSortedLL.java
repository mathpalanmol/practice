package list.linkedList;

public class MergetwoSortedLL {
	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertElement(5); /* Insertion */
		list1.insertElement(7);
		list1.insertElement(9);

		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertElement(6); /* Insertion */
		list2.insertElement(8);
		list2.insertElement(10);
		list1.insertElement(12);
		Link start = mergeIterative(list1.first, list2.first);
		display(start);
	}

	private static void display(Link start) {
		Link current = start;
		while (current != null) {
			System.out.println(current.key);
			current = current.next;
		}

	}

	/* Recursive */
	static Link mergeLists(Link list1, Link list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)   //similar to lca
			return list1;

		if (list1.key <= list2.key) {
			list1.next = mergeLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeLists(list1, list2.next);
			return list2;
		}
	}

	/**
	 * Iterative merge of two sorted linked lists.
	 *
	 * Example:
	 * list1: 5 -> 7 -> 9 -> 12
	 * list2: 6 -> 8 -> 10
	 * result: 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 12
	 */
	static Link mergeIterative(Link list1, Link list2) {
		// dummy node avoids special-casing the merged list head
		Link dummy = new Link(0);
		// tail always points to the last node in the merged list so far
		Link tail = dummy;

		// compare both heads and pick the smaller node each time
		while (list1 != null && list2 != null) {
			if (list1.key <= list2.key) {
				tail.next = list1;      // attach smaller node from list1
				list1 = list1.next;     // move list1 forward
			} else {
				tail.next = list2;      // attach smaller node from list2
				list2 = list2.next;     // move list2 forward
			}
			tail = tail.next;           // advance tail to the node just added
		}

		// one list is finished — plug in the remaining nodes from the other list
		tail.next = (list1 != null) ? list1 : list2;

		// dummy.next is the real head of the merged list
		return dummy.next;
	}

	/**
	 * Iterative merge without a dummy node.
	 * Pick the smaller head first, then attach remaining nodes with a tail pointer.
	 */
	static Link mergeListsIterative(Link list1, Link list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		// choose the smaller head as the start of the merged list
		Link head;
		if (list1.key <= list2.key) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}

		Link tail = head;

		while (list1 != null && list2 != null) {
			if (list1.key <= list2.key) {
				tail.next = list1;
				list1 = list1.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
			}
			tail = tail.next;
		}

		tail.next = (list1 != null) ? list1 : list2;
		return head;
	}

}
