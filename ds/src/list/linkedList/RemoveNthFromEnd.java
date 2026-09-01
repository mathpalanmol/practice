package list.linkedList;

/**
 * Remove Nth Node From End of List (LeetCode #19)
 *
 * <p>Given the head of a linked list, remove the nth node from the end and return its head.
 *
 * <p>Examples:
 * <pre>
 * 1 -> 2 -> 3 -> 4 -> 5, n=2  =>  1 -> 2 -> 3 -> 5
 * 1, n=1                      =>  (empty)
 * 1 -> 2, n=1                 =>  1
 * </pre>
 */
public class RemoveNthFromEnd {

    /**
     * Two-pointer approach without a dummy node.
     * Advance {@code fast} by n steps. If {@code fast} is null, remove head.
     * Otherwise move both until {@code fast} is at the last node; {@code slow}
     * is just before the target.
     */
    public static Link removeNthFromEnd(Link head, int n) {
        if (head == null) {
            return null;
        }

        Link fast = head;
        Link slow = head;

        // move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return head; // n too large
            }
            fast = fast.next;
        }

        // n == length → remove head
        if (fast == null) {
            return head.next;
        }

        // move until fast is at last node; slow is just before target
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head; // head unchanged (not removed)
    }

    private static Link buildList(int... values) {
        Link dummy = new Link(0);
        Link curr = dummy;
        for (int value : values) {
            curr.next = new Link(value);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(Link head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        while (head != null) {
            System.out.print(head.key);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("1->2->3->4->5, n=2: ");
        printList(removeNthFromEnd(buildList(1, 2, 3, 4, 5), 2));

        System.out.print("1, n=1: ");
        printList(removeNthFromEnd(buildList(1), 1));

        System.out.print("1->2, n=1: ");
        printList(removeNthFromEnd(buildList(1, 2), 1));

        System.out.print("1->2, n=2: ");
        printList(removeNthFromEnd(buildList(1, 2), 2));
    }
}
