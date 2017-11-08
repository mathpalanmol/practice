package ds.list.linkedList;

public class LinkList {
	Link first;

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
	
	/* Reverse - Iteration */
	public Link reverse(Link current) {
		if (current.next == null){
			first = current;
			return current;}
		Link start = reverse(current.next);
		start.next = current;
		if (start.next == current)
			current.next = null;

		return current;

	}

	/* To check whether the list is empty or not */
	public boolean isEmpty() {
		return first == null;
	}

	/* To insert new element in the list */
	public void insertElement(int key) {
		Link newLink = new Link(key);
		newLink.next = first;
		first = newLink;
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
}
