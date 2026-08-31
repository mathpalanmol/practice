package com.practice.prepare;

/**
 * Reverse Nodes in k-Group (LeetCode #25)
 *
 * <p>Reverse the list k nodes at a time. If remaining nodes &lt; k, leave them unchanged.
 *
 * <p>Example: [1,2,3,4,5], k=2 → [2,1,4,3,5]
 */
public class ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;

        // check if there are at least k nodes
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        if (count < k) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(node, k);
        return prev;
    }
}
