package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseLinkedListInPairsTest {

    private final ReverseLinkedListInPairs solver = new ReverseLinkedListInPairs();

    @Test
    void reversesPairsOfFourNodes() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairs(buildList(1, 2, 3, 4));
        assertEquals("2 -> 1 -> 4 -> 3", listToString(result));
    }

    @Test
    void leavesLastNodeWhenOddCount() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairs(buildList(1, 2, 3));
        assertEquals("2 -> 1 -> 3", listToString(result));
    }

    @Test
    void handlesSingleNode() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairs(buildList(1));
        assertEquals("1", listToString(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(solver.reversePairs(null));
    }

    @Test
    void dummyReversesPairsOfFourNodes() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairsWithDummy(buildList(1, 2, 3, 4));
        assertEquals("2 -> 1 -> 4 -> 3", listToString(result));
    }

    @Test
    void dummyLeavesLastNodeWhenOddCount() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairsWithDummy(buildList(1, 2, 3));
        assertEquals("2 -> 1 -> 3", listToString(result));
    }

    @Test
    void recursiveReversesPairsOfFourNodes() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairsRecursive(buildList(1, 2, 3, 4));
        assertEquals("2 -> 1 -> 4 -> 3", listToString(result));
    }

    @Test
    void recursiveLeavesLastNodeWhenOddCount() {
        ReverseLinkedListInPairs.ListNode result = solver.reversePairsRecursive(buildList(1, 2, 3));
        assertEquals("2 -> 1 -> 3", listToString(result));
    }

    private static ReverseLinkedListInPairs.ListNode buildList(int... values) {
        ReverseLinkedListInPairs.ListNode dummy = new ReverseLinkedListInPairs.ListNode(0);
        ReverseLinkedListInPairs.ListNode curr = dummy;
        for (int value : values) {
            ReverseLinkedListInPairs.ListNode node = new ReverseLinkedListInPairs.ListNode(value);
            curr.next = node;
            curr = node;
        }
        return dummy.next;
    }

    private static String listToString(ReverseLinkedListInPairs.ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            if (sb.length() > 0) {
                sb.append(" -> ");
            }
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}
