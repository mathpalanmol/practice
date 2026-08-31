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
        // Step 0: handle edge cases
        if (head == null || k <= 1) {
            return head;
        }

        // Step 1: count total nodes to know when to stop
        int remaining = countNodes(head);
        ListNode beforeGroup = null; // node just before the current group (null for first group)

        // Step 2: process each full group of k nodes
        while (remaining >= k) {
            // Step 2a: mark the first node of this group
            ListNode groupStart = (beforeGroup == null) ? head : beforeGroup.next;
            ListNode curr = groupStart;
            ListNode prev = null;

            // Step 2b: reverse k nodes (standard iterative reverse)
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next; // save next before rewiring
                curr.next = prev;          // reverse pointer
                prev = curr;               // prev moves forward
                curr = next;               // curr moves forward
            }
            // after loop: prev = new head, groupStart = new tail, curr = node after group

            // Step 2c: reconnect reversed group to the rest of the list
            groupStart.next = curr; // tail of group -> remaining list (plug in back)
            if (beforeGroup == null) {
                head = prev; // first group: list head -> new head of group (plug in front)
            } else {
                beforeGroup.next = prev; // later groups: previous tail -> new head of group (plug in front)
            }
            // after reversal, groupStart is the tail of this group — use it as
            // the node before the NEXT group (so next iteration can do beforeGroup.next = ...)
            beforeGroup = groupStart;

            // Step 2d: fewer nodes left to process
            remaining -= k;
        }

        // Step 3: return updated head
        return head;
    }

    /**
     * Recursive version:
     * 1. If fewer than k nodes remain, return start unchanged.
     * 2. Reverse k nodes in a while loop.
     * 3. Connect tail (start) to recursive result on the rest.
     * 4. Return pre (new head of reversed group).
     */
    public ListNode reverseKGroupRecursive(ListNode start, int k) {
        if (start == null || k <= 1) {
            return start;
        }

        // check k nodes exist before reversing — avoids mutating a partial tail group
        ListNode node = start;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return start;
            }
            node = node.next;
        }

        ListNode current = start;
        int count = 0;
        ListNode pre = null;

        // reverse k nodes: for k=3 on 1->2->3->4->5, loop runs 3 times and current lands on 4
        while (current != null && count < k) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
            count++;
        }

        // start is now the tail of the reversed group; connect it to the rest
        start.next = reverseKGroupRecursive(current, k);

        return pre;
    }

    private int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
