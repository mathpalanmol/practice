package ds.tree.heap;

public class Node {
	public int key;
	public Node lChild;
	public Node rChild;

	public Node(int key) {
		this.key = key;
	}

	public void display() {
		System.out.println("key: " + key);
	}
}
