package ds.list.stackImpl;

public class LinkStack {
	Link first;

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int key) {
		Link newLink = new Link(key);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link delLink = first;
		first = first.next;
		return delLink;
	}
	
	public void displayStackElements(){
		Link current = first;
		while(current != null){
			current.display();
			current = current.next;
		}
		System.out.println("**********");
	}
}
