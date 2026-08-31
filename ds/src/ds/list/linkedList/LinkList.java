package ds.list.linkedList;

public class LinkList {
	Link first;
	Link start;

	/* Reverse - Recursion */
	public Link reverseI(Link current) {
		Link pre = null;
		while (current != null) {
			Link temp = current.next;
			current.next = pre;
			pre = current;
			current = temp;
		}
		return pre;
	}

	/* Reverse - Recursion */
	public Link reverse(Link current) {
		if (current.next == null) {
			first = current;
			return current;
		}
		Link start = reverse(current.next);
		start.next = current;
		if (start.next == current) // otherwise 1st and 2nd node will always form a circular loop.
			current.next = null;

		return current;

	}
	//or one more for reverse
	public Link reverseRec(Link start) {
		return reverse(null, start);
	}

	private Link reverse(Link pre, Link start) {
		if(start == null) {
			first = pre;
			return pre;
		}
		Link last = reverse(start, start.next);
		last.next = pre;
		return pre;
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
					current = pre.next; // Imp: no need to increment previous; prev will remain same when removal will h app
				} else {
					pre = current;
					current = current.next;
				}
			}
			start = start.next;
		}
		return first;
	}

}
