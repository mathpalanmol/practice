package ds.tree;

public class Node {
	public int key;
	public float value;
	public int ht;
	public Node lChild;
	public Node rChild;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public void display() {
		System.out.println("key: " + key + " Value: " + value);
	}
}
