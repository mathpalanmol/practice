package list.linkedList;

import java.util.HashSet;

/**
 * Remove duplicates from an unsorted linked list.
 *
 * <p>Approach (this file): HashSet of seen values while walking the list.
 * If the current value was seen before, unlink the node; otherwise keep it and
 * add the value to the set.
 *
 * <p>Time: O(n), Space: O(n). Original order is preserved.
 *
 * <p>Alternate (not implemented here): sort the list O(n log n), then remove
 * adjacent duplicates in O(n). That uses less extra space but does not keep
 * the original order.
 */
public class RemoveDuplicates 
{
    static class node 
    {
        int val;
        node next;
 
        public node(int val) 
        {
            this.val = val;
        }
    }
     
    /**
     * Remove duplicate values from an unsorted list using a HashSet.
     * Time: O(n). Returns the (possibly new) head.
     */
    static node removeDuplicate(node head) 
    {
        HashSet<Integer> hs = new HashSet<>();

        node current = head;
        node prev = null;
        while (current != null) 
        {
            int curval = current.val;

            if (hs.contains(curval)) {
                // duplicate — unlink current (safe even if removing head)
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * Same HashSet approach with a dummy node.
     * {@code prev} always starts at dummy, so no null check when unlinking.
     */
    static node removeDuplicateWithDummy(node head) {
        node dummy = new node(0);
        dummy.next = head;

        HashSet<Integer> hs = new HashSet<>();
        node prev = dummy;
        node current = head;

        while (current != null) {
            if (hs.contains(current.val)) {
                // unlink current; prev stays put
                prev.next = current.next;
            } else {
                hs.add(current.val);
                prev = current;
            }
            current = current.next;
        }

        return dummy.next;
    }
     
    /* Function to print nodes in a given linked list */
    static void printList(node head) 
    {
        while (head != null) 
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
 
    public static void main(String[] args) 
    {
        node start = buildList(10, 12, 11, 11, 12, 11, 10);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        start = removeDuplicate(start);
        System.out.println("\nAfter removeDuplicate :");
        printList(start);

        node start2 = buildList(10, 12, 11, 11, 12, 11, 10);
        System.out.println("\n\nBefore removeDuplicateWithDummy :");
        printList(start2);

        start2 = removeDuplicateWithDummy(start2);
        System.out.println("\nAfter removeDuplicateWithDummy :");
        printList(start2);
    }

    private static node buildList(int... values) {
        node dummy = new node(0);
        node tail = dummy;
        for (int value : values) {
            tail.next = new node(value);
            tail = tail.next;
        }
        return dummy.next;
    }
}