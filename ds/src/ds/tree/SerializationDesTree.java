package ds.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializationDesTree {
	static Node root;
	static Node root1; // after desearilization keep a new root node ref.
	static List<Node> inOrderList = new ArrayList<Node>();
	static List<Node> preOrderList = new ArrayList<Node>();
	
	static List<Node> inOrderListser = new ArrayList<Node>();
	static List<Node> preOrderListser = new ArrayList<Node>();

	public static void main(String[] args) {
		createTree();
		serialize();
		deserialize();
	}

	private static void createTree() {
		if (root == null) {
			root = new Node(50);
		}
		root.lchild = new Node(25);

		root.lchild.lchild = new Node(10);
		root.lchild.rchild = new Node(30);

		root.rchild = new Node(75);
		root.rchild.lchild = new Node(60);
		root.rchild.rchild = new Node(90);
	}

	private static void serialize() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("/home/anmol/Desktop/TreeSerialize");

			System.out.println("Inorder");
			for (Node node : inOrder(root)) {
				System.out.print(node.data + ", ");
				fw.write(node.data.toString() + " ");
			}
			fw.write("\n");
			System.out.println("\n preorder");
			for (Node node : preOrder(root)) {
				System.out.print(node.data + ", ");
				fw.write(node.data.toString() + " ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	private static void deserialize() {
		populateTreeData();
		Node[] inOrderArray = inOrderListser.toArray(new Node[inOrderList.size()]);
		Node[] preOrderArray = preOrderListser.toArray(new Node[preOrderList.size()]);
		root1 = deserialize(inOrderArray, preOrderArray, 0, inOrderArray.length - 1, 0);// low, high, index-->to iterate
		// preorder array

	}
    
	private static void populateTreeData() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("/home/anmol/Desktop/TreeSerialize"));
			inOrderListser = getInOrderfromFile(br);
			preOrderListser = getPreOrderfromFile(br);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private static List<Node> getPreOrderfromFile(BufferedReader br) throws IOException {
		String values = br.readLine();
        String[] tokens = values.split(" ");
        Node[] nodeTokens = new Node[tokens.length];
        for(int i=0; i<tokens.length; i++) {
        	nodeTokens[i] = new Node(Integer.parseInt(tokens[i]));
        }
        return Arrays.asList(nodeTokens);
	}

	private static List<Node> getInOrderfromFile(BufferedReader br) throws IOException {
		String values = br.readLine();
        String[] tokens = values.split(" ");
        Node[] nodeTokens = new Node[tokens.length];
        for(int i=0; i<tokens.length; i++) {
        	nodeTokens[i] = new Node(Integer.parseInt(tokens[i]));
        }
        return Arrays.asList(nodeTokens);
	}

	private static Node deserialize(Node[] inOrderArray, Node[] preOrderArray, int low, int high, int index) {
		if (low > high)
			return null;
		else {
			if (index < preOrderArray.length) {
				int value = preOrderArray[index++].data;
				Node root = new Node(value);
				int rootIndex = getIndex(inOrderArray, value);
				root.lchild = deserialize(inOrderArray, preOrderArray, low, rootIndex - 1, index);
				root.rchild = deserialize(inOrderArray, preOrderArray, rootIndex + 1, high, index);
			}
			return root;

		}
	}

	private static int getIndex(Node[] inOrderArray, int value) {
		for (int i = 0; i < inOrderArray.length; i++) {
			if (inOrderArray[i].data == value) {
				return i;
			}
		}
		return -1;
	}

	static List<Node> inOrder(Node root) {
		if (root == null)
			return null;
		inOrder(root.lchild);
		inOrderList.add(root);
		inOrder(root.rchild);
		return inOrderList;

	}

	static List<Node> preOrder(Node root) {
		if (root == null)
			return null;
		preOrderList.add(root);
		preOrder(root.lchild);
		preOrder(root.rchild);
		return preOrderList;
	}

	public List<Node> getSerialize() {
		return inOrderList;
	}

	public List<Node> getDeserialize() {
		return preOrderList;
	}

	static class Node {
		Integer data;
		Node lchild;
		Node rchild;

		Node(int data) {
			this.data = data;
		}
	}

}
