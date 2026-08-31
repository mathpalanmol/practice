package ds.list.doublyLinkedList;

public class Link {
    int key;
	Link next;
	Link previous;
	
	public Link(int key){
		this.key = key;
	}
	
	public void display(){
		System.out.println(key);
	}
}
