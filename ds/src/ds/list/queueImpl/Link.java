package ds.list.queueImpl;

public class Link {

	int key;
	Link next;

	public Link(int key) {
		this.key = key;
	}

	public void display() {
		System.out.println(key);
	}

}
