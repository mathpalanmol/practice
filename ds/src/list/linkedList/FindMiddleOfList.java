package list.linkedList;

/**
 * Middle of the Linked List (LeetCode #876)
 *
 * <p>Given the head of a singly linked list, return the middle node.
 * If there are two middle nodes, return the second one.
 *
 * <p>Examples:
 * <pre>
 * 1 -> 2 -> 3 -> 4 -> 5  =>  3
 * 1 -> 2 -> 3 -> 4       =>  3
 * 1 -> 2                 =>  2
 * </pre>
 */
public class FindMiddleOfList {

    /**
     * Slow/fast pointer: fast moves 2 steps, slow moves 1 step.
     * When fast reaches the end, slow is at the middle.
     */
    public static Link findMiddle(Link head) {
        if (head == null) {
            return null;
        }

        Link slow = head;
        Link fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        Link list1 = buildList(1, 2, 3, 4, 5);
        System.out.print("List: ");
        printList(list1);
        System.out.println("Middle: " + findMiddle(list1).key);

        Link list2 = buildList(1, 2, 3, 4);
        System.out.print("List: ");
        printList(list2);
        System.out.println("Middle: " + findMiddle(list2).key);

        Link list3 = buildList(1, 2);
        System.out.print("List: ");
        printList(list3);
        System.out.println("Middle: " + findMiddle(list3).key);
    }
}
