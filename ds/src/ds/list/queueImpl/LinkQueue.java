package ds.list.queueImpl;

public class LinkQueue {

	Link first;
	Link last;

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertLast(int key) {
		Link newLink = new Link(key);
		if (isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
	}

	public void deleteFirst() {
		if (isEmpty()) {
			last = null;
			return;
		}
		first = first.next;

	}
	
	public void displayQueueElements(){
		Link current = first;
		while(current != null){
			current.display();
			current = current.next;
		}
		System.out.println("**********");
	}

}
