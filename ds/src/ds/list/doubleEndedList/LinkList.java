package ds.list.doubleEndedList;

/*Unfortunately, making a list double-ended doesn't help you to delete the last link, because
 there is still no reference to the next-to-last link, whose next field would need to be
 changed to null if the last link were deleted. To conveniently delete the last link, you
 would need a doubly linked list, which we'll look at soon. (Of course, you could also
 traverse the entire list to find the last link, but that's not very efficient.)*/
public class LinkList {
	Link first;
	Link last;

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int key) {
		Link newLink = new Link(key);
		if (isEmpty())
			last = newLink;
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(int key) {
		Link newLink = new Link(key);
		if (isEmpty())
			first = newLink;
		last.next = newLink;
		last = newLink;
	}

	public int deleteFirst() {
		int temp = first.key;
		if (first.next == null)
			last = null;
		first = first.next;
		return temp;
	}

	/*
	 * (Of course, you could also traverse the entire list to find the last
	 * link, but that's not very efficient.)
	 */
	public int deleteLast() {
		Link current = first;
		Link lastCurrent = null;
		int temp = last.key;
		if(!isEmpty()){
		if (first == last) {
			first = first.next;/*
								 * first = null and last = null is also fine
								 * here
								 */
			last = first;
			return temp;
		}
		while (current.key != temp) {
			lastCurrent = current;
			current = current.next;
		}
		last = lastCurrent;
		lastCurrent.next = current.next;}
		return temp;
	}

	public void displayList() {
		Link current = first;
		if (!isEmpty()) {
			while (current != null) {
				current.display();
				current = current.next;
			}
		}
		System.out.println("**********");
	}

}
