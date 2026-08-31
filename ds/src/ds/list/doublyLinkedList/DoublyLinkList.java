package ds.list.doublyLinkedList;

/*
 * In doubly link list we can traverse in both the directions.
 The downside of doubly linked lists is that every time you insert or delete a link you must
 deal with four links instead of two: two attachments to the previous link and two attachments
 to the following one. Also, of course, each link is a little bigger because of the extra 
 reference.
 A doubly linked list doesn't necessarily need to be a double-ended list (keeping a reference 
 to the last element on the list).
 */
public class DoublyLinkList {
	Link first = null;
	Link last = null;

	public boolean isEmpty() {
		return (first == null);
	}

	public void displayForward() {
		System.out.println("List first --> last");
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("//////////////");
	}

	public void displayBackward() {
		System.out.println("List last --> first");
		Link current = last;
		while (current != null) {
			current.display();
			current = current.previous;
		}
		System.out.println("\\\\\\\\\\\\\\");
	}

	public void insertFirst(int key) {
		Link newLink = new Link(key);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;

		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(int key) {
		Link newLink = new Link(key);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		newLink.previous = last;
		last = newLink;
	}

	public Link deleteFirst() {
		Link temp = first;
		if (first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}

	public Link deleteLast() {
		Link temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}

	/* @author: Anmol.m */
	public Link deleteKey(int key) {
		Link current = first;
		while (current.key != key) {
			current = current.next;
			if (current == null)
				return null;
		}
		if (first == last) {
			first = first.next;
			last = first;
		} else if (current == first && current != last) {
			first.next.previous = null;
			first = first.next;
		} else if (current == last) {
			current.previous.next = null;
			last = last.previous;
		} else {
			current.previous.next = current.next;
		}

		return current;
	}

	/* @author: Anmol.m */
	public boolean insertAfter(int refKey, int key) {
		Link current = first;
		Link newLink = new Link(key);
		while (current.key != refKey) {
			current = current.next;
			if (current == null)
				return false;
		}
		if (first == last) {
			newLink.next = current;
			newLink = current.previous;
		} else if (current == first && current != last) {
			newLink.next = current;
			current.previous = newLink;
			first = newLink;

		} /*
			 * else if (current == last) {//not required we can't insert element at last.
			 * newLink.next = current; current.previous.next = newLink; newLink.previous =
			 * current.previous; current.previous = newLink;
			 * 
			 * }
			 */else {
			newLink.next = current;
			current.previous.next = newLink;
			newLink.previous = current.previous;
			current.previous = newLink;

		}
		return true;
	}

	

	public int getLength(Link start) {
		Link current = start;
		int len = 0;
		while (current != null) {
			len++;
			current = current.next;
		}
		return len;
	}



	private void inOrder(Link root) {
		if (root == null)
			return;
		inOrder(root.previous);
		System.out.println(root.key);
		inOrder(root.next);
	}

	// Link root;

	private Link linkToBinary(int len) {
		if (len == 0)
			return null;
		Link left = linkToBinary(len / 2);
		Link current = first;
		first = first.next;
		current.previous = left;
		Link right = linkToBinary(len - (len / 2) - 1);
		current.next = right;
		return current;
	}
	public Link getMiddle(Link start) {
		Link slow = start;
		Link fast = start;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			if (fast == null)
				break;
			slow = slow.next;
		}
		return slow;
	}
	// working fine
	// len is actual length of linkedlist.
	public Link linkToBinary(Link start, int len) {
		if (len == 0 || start == null)
			return null;
        int mid = len/2;
        //find middlelink: pass start node and len
        // length will be reduced all the times
		Link middleLink = getMiddle(start, len);
		Link temp = middleLink.next;
		middleLink.next = null;
		
		Link current = middleLink;
		//start will end at middleLink. but we've to exclude middleLink, that'sy len-mid-1
		// example len = 5 - actual length
		// mid = 5/2= 2
		// len-mid-1 = 5-2-1 = 2 nodes on left
		// mid = 2 = 2 nodes on right
		
		current.previous = linkToBinary(start, len-mid-1);// len-mid-1 --> actual length
		current.next = linkToBinary(temp, mid); // 6/2 or 7/2 = 3(len) towards right
		

		return current;
	}

	private Link getMiddle(Link start, int len) {
		Link slow = start;
		Link fast = start;
		int counter =0;
		// start with 0 and len is actual that's y <
		while (counter < len && fast != null && fast.next != null) {
			fast = fast.next.next;
			if (fast == null)
				break;
			slow = slow.next;
		}
		return slow;
	}
	
	

}
