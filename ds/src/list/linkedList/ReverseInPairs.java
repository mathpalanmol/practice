package list.linkedList;

/**
 * Swap Nodes in Pairs / Reverse Linked List in Pairs (LeetCode #24)
 *
 * <p>Swap every two adjacent nodes and return the new head.
 *
 * <p>Example: 1 -> 2 -> 3 -> 4 -> 5  =>  2 -> 1 -> 4 -> 3 -> 5
 */
public class ReverseInPairs {

    /**
     * Recursive approach (swap before recursion):
     * 1. Base case: fewer than 2 nodes — return head.
     * 2. Save {@code second} and {@code rest} before rewiring.
     * 3. Swap the pair: {@code second -> head}.
     * 4. Attach tail to recursive result: {@code head.next = reversePairs(rest)}.
     * 5. Return {@code second} (new head of this pair).
     */
    public static Link reversePairs(Link head) {
        if (head == null || head.next == null) {
            return head;
        }

        Link second = head.next;
        Link rest = second.next;

        second.next = head;              // swap first
        head.next = reversePairs(rest);  // then recurse on rest

        return second;
    }

    /**
     * Same idea as reversePairs, but recurse-then-swap style.
     * Must save {@code rest} before setting {@code second.next = first},
     * otherwise second.next becomes first and the remaining list is lost.
     */
    public static Link reversePairs1(Link head) {
        if (head == null || head.next == null) {
            return head;
        }

        Link first = head;
        Link second = head.next;
        Link rest = second.next; // save before swap

        second.next = first;
        first.next = reversePairs1(rest);
        return second;
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
        Link list = buildList(1, 2, 3, 4, 5);
        System.out.print("Original:  ");
        printList(list);

        Link result = reversePairs1(list);
        System.out.print("Reversed:  ");
        printList(result);
    }
}
