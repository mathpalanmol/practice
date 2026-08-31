package list.linkedList;

/**
 * Reverse Nodes in k-Group (LeetCode #25)
 *
 * <p>Reverse the list k nodes at a time. If remaining nodes &lt; k, leave them unchanged.
 *
 * <p>Example: [1,2,3,4,5], k=2 → [2,1,4,3,5]
 */


class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;

        // Check if there are at least k nodes remaining
        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        if (count < k) {
            return head; // fewer than k nodes left, don't reverse
        }

        // node now points to the (k+1)-th node — start of the next group
        ListNode newHead = reverseKGroup(node, k);

        // Reverse current group of k nodes
        ListNode prev = newHead;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // new head of this group
    }
}
