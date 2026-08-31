package com.practice.prepare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ReverseNodesInKGroupTest {

    private final ReverseNodesInKGroup solver = new ReverseNodesInKGroup();

    @Test
    void reversesGroupsOfTwo() {
        ReverseNodesInKGroup.ListNode result = solver.reverseKGroup(buildList(1, 2, 3, 4, 5), 2);
        assertEquals("2 -> 1 -> 4 -> 3 -> 5", listToString(result));
    }

    @Test
    void reversesGroupsOfThree() {
        ReverseNodesInKGroup.ListNode result = solver.reverseKGroup(buildList(1, 2, 3, 4, 5), 3);
        assertEquals("3 -> 2 -> 1 -> 4 -> 5", listToString(result));
    }

    @Test
    void leavesRemainingNodesWhenNotMultipleOfK() {
        ReverseNodesInKGroup.ListNode result = solver.reverseKGroup(buildList(1, 2, 3, 4), 3);
        assertEquals("3 -> 2 -> 1 -> 4", listToString(result));
    }

    @Test
    void handlesSingleNode() {
        ReverseNodesInKGroup.ListNode result = solver.reverseKGroup(buildList(1), 1);
        assertEquals("1", listToString(result));
    }

    @Test
    void handlesEmptyList() {
        assertNull(solver.reverseKGroup(null, 2));
    }

    private static ReverseNodesInKGroup.ListNode buildList(int... values) {
        ReverseNodesInKGroup.ListNode dummy = new ReverseNodesInKGroup.ListNode(0);
        ReverseNodesInKGroup.ListNode curr = dummy;
        for (int value : values) {
            ReverseNodesInKGroup.ListNode node = new ReverseNodesInKGroup.ListNode(value);
            curr.next = node;
            curr = node;
        }
        return dummy.next;
    }

    private static String listToString(ReverseNodesInKGroup.ListNode head) {
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
