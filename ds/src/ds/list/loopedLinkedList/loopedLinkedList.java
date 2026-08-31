package ds.list.loopedLinkedList;

public class loopedLinkedList {
	Link first = null;

	public boolean findLoop() {
		Link slowLink = first;
		Link fastLink = first;
		while (true) {
			slowLink = slowLink.next;
			if (slowLink == null || fastLink == null || fastLink.next == null)
				break;
			else
				fastLink = fastLink.next.next;
			if (slowLink == fastLink) {
				return true;
			}
		}
		return false;
	}

	public void insert(int key, float value) {
		Link newLink = new Link(key, value);
		if (isEmpty())
			first = newLink;
		else
			newLink.next = first;
		first = newLink;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void display() {
		Link current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println("**********");
	}

}
