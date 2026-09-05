package list.linkedList;

/**
 * Singly linked list with insert, search, delete, and reverse operations.
 */
public class SinglyLinkedList {
	Link first;
	Link start;

	/**
	 * Iterative reverse: walk the list and flip each {@code next} pointer.
	 */
	public Link reverseIterative(Link current) {
		Link pre = null;
		while (current != null) {
			Link temp = current.next; // save next
			current.next = pre;       // reverse link
			pre = current;            // move pre forward
			current = temp;           // move current forward
		}
		first = pre;
		return pre;
	}

	/**
	 * Recursive reverse — same idea as iterative, one node at a time.
	 *
	 * Call: reverseRecursive(null, first)
	 *
	 * Example 1 → 2 → 3:
	 *   reverse(null, 1) → reverse(1, 2) → reverse(2, 3) → reverse(3, null)
	 *   when current is null, prev is 3 (new head)
	 *   each call already did: current.next = prev
	 */
	public Link reverseRecursive(Link prev, Link current) {
		// reached end — prev is the new head
		if (current == null) {
			return prev;
		}

		Link next = current.next;   // 1. remember the rest of the list
		current.next = prev;        // 2. reverse this one link
		return reverseRecursive(current, next); // 3. do the same for the rest
	}

	/** Starts reverse from the list head and updates {@code first}. */
	public Link reverseRecursive() {
		first = reverseRecursive(null, first);
		return first;
	}

	/* To check whether the list is empty or not */
	public boolean isEmpty() {
		return first == null;
	}

	/* To insert new element in the list */
	public void insertElement(int key) {
		Link newLink = new Link(key);
		if (first == null) {
			first = newLink;
			start = newLink;
			return;
		}
		start.next = newLink;
		start = start.next;
	}

	/* To display the elements of the list */
	public void displayList() {
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("*************");
	}

	/* To display the elements of the list with given node */
	public void displayList(Link start) {
		Link current = start;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("*************");
	}

	/* To find the element in the list */
	public Link find(int key) {
		Link current = first;

		while (current != null) {
			if (current.key == key) {
				return current;
			}
			current = current.next;
		}

		return current;
	}

	/* To delete an element from the list */
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while (current.key != key) {
			if (current.next == null) { /* didn't find it */
				return null;
			}
			previous = current;
			current = current.next;
		}
		if (current == first) { /* for the first node and the only one node */
			first = first.next;
		} else {
			previous.next = current.next;
		}

		return current;
	}

	// remove duplicates
	Link removeDuplicates(Link first) {
		Link start = first; // take pointer to first node
		while (start != null) {
			Link pre = start;
			Link current = start.next;
			while (current != null) {
				if (start.key == current.key) {
					pre.next = current.next;
					current = pre.next; // Imp: no need to increment previous; prev will remain same when removal will happen
				} else {
					pre = current;
					current = current.next;
				}
			}
			start = start.next;
		}
		return first;
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertElement(1);
		list.insertElement(2);
		list.insertElement(3);
		list.insertElement(4);
		list.insertElement(5);

		System.out.println("Original:");
		list.displayList();

		list.reverseRecursive();
		System.out.println("After reverseRecursive:");
		list.displayList();
	}
}
