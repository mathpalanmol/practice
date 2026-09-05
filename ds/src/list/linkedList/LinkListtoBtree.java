package list.linkedList;

/**
 * Convert Sorted List to Binary Search Tree (LeetCode #109)
 *
 * <p>Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height-balanced BST.
 *
 * <p>Example:
 * <pre>
 * -10 -> 0 -> 5 -> 9  =>       0
 *                            /     \
 *                          -10      9
 *                            \
 *                             5
 * </pre>
 */
public class LinkListtoBtree {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	private ListNode current;

	/**
	 * Build a balanced BST by treating the sorted list like an in-order traversal:
	 * left subtree, root, right subtree.
	 */
	public TreeNode sortedListToBST(ListNode head) {
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}

		current = head;
		return buildBST(0, length - 1);
	}

	private TreeNode buildBST(int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;

		TreeNode left = buildBST(start, mid - 1);
		TreeNode root = new TreeNode(current.val);
		current = current.next;
		TreeNode right = buildBST(mid + 1, end);

		root.left = left;
		root.right = right;
		return root;
	}

	private static ListNode buildList(int... values) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		for (int value : values) {
			tail.next = new ListNode(value);
			tail = tail.next;
		}
		return dummy.next;
	}

	private static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	private static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) {
		LinkListtoBtree solver = new LinkListtoBtree();

		ListNode list = buildList(-10, -3, 0, 5, 9);
		TreeNode root = solver.sortedListToBST(list);

		System.out.print("In-order (should match sorted list): ");
		inOrder(root);
		System.out.println();

		System.out.print("Pre-order: ");
		preOrder(root);
		System.out.println();
	}
}
