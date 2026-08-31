package com.practice.prepare;

/**
 * Swap Nodes in Pairs / Reverse Linked List in Pairs (LeetCode #24)
 *
 * <p>Given the head of a linked list, swap every two adjacent nodes and return the new head.
 * If the number of nodes is odd, the last node stays in place.
 *
 * <p>Examples:
 * <pre>
 * Input:  1 -> 2 -> 3 -> 4
 * Output: 2 -> 1 -> 4 -> 3
 *
 * Input:  1 -> 2 -> 3
 * Output: 2 -> 1 -> 3
 *
 * Input:  1
 * Output: 1
 * </pre>
 */
public class ReverseLinkedListInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Iterative approach without a dummy node.
     */
    public ListNode reversePairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        ListNode prev = null;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            head = second.next;

            second.next = first;
            if (prev != null) {
                prev.next = second;
            }
            first.next = head;

            prev = first;
        }

        return newHead;
    }

    /**
     * Iterative approach with a dummy node.
     * {@code prev} always points to the node before the current pair.
     */
    public ListNode reversePairsWithDummy(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // swap: prev -> second -> first -> rest
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
        }

        return dummy.next;
    }

    /**
     * Recursive approach:
     * 1. Base case: fewer than 2 nodes — return head.
     * 2. Swap the first pair, then recurse on the rest.
     * 3. Return the new head (second node).
     */
    public ListNode reversePairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        head.next = reversePairsRecursive(second.next);
        second.next = head;
        return second;
    }
}
