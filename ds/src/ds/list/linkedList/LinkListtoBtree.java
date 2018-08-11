package ds.list.linkedList;

public class LinkListtoBtree {
	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Definition for binary tree
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {
		ListNode h;

		public TreeNode sortedListToBST(ListNode head) {
			if (head == null)
				return null;

			h = head;
			int len = getLength(head);
			return sortedListToBST(0, len - 1);
		}

		int getLength(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
			int mid = 0;
			while (fast != null && fast.next != null) {
				fast = fast.next;
				if (fast == null)
					return mid;
				slow = slow.next;
				mid++;
			}
			return mid;
		}

		// build tree bottom-up
		public TreeNode sortedListToBST(int start, int end) {
			if (start > end)
				return null;

			// mid
			int mid = (start + end) / 2;

			TreeNode left = sortedListToBST(start, mid - 1);
			TreeNode root = new TreeNode(h.val);
			h = h.next;
			System.out.println("mid: " + mid);
			TreeNode right = sortedListToBST(mid + 1, end);

			root.left = left;
			root.right = right;

			return root;
		}

		// second approach

		// working fine
		// len is actual length of linkedlist.
		public TreeNode linkToBinary(Link start, int len) {
			if (len == 0 || start == null)
				return null;
			int mid = len / 2;
			// find middlelink: pass start node and len
			// length will be reduced all the times
			Link middleLink = getMiddle(start, len);
			TreeNode root = new TreeNode(middleLink.key);
			Link temp = middleLink.next;
			middleLink.next = null;

			// start will end at middleLink. but we've to exclude middleLink, that'sy
			// len-mid-1
			// example len = 5 - actual length
			// mid = 5/2= 2
			// len-mid-1 = 5-2-1 = 2 nodes on left
			// mid = 2 = 2 nodes on right

			TreeNode linkToBinary = linkToBinary(start, len - mid - 1);// len-mid-1 --> actual length
			root.left = linkToBinary;
			TreeNode linkToBinary2 = linkToBinary(temp, mid); // 6/2 or 7/2 = 3(len) towards right
			root.right = linkToBinary2;

			return root;
		}

		private Link getMiddle(Link start, int len) {
			Link slow = start;
			Link fast = start;
			int counter = 0;
			while (counter < len && fast != null && fast.next != null) {
				fast = fast.next.next;
				if (fast == null)
					break;
				slow = slow.next;
			}
			return slow;
		}

	}
}
