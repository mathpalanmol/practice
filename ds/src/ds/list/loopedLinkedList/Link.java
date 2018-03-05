package ds.list.loopedLinkedList;

public class Link {
    int key;
    float value;
	Link next;

	public Link(int key, float value) {
		this.key = key;
		this.value = value;
	}
	
	public void display(){
		System.out.println("Key: " + key + " Value: " + value);
	}

}
