package list.linkedList;

/**
 * Reverse Nodes in k-Group (LeetCode #25)
 *
 * <p>Reverse the list k nodes at a time. If remaining nodes &lt; k, leave them unchanged.
 *
 * <p>Example: [1,2,3,4,5], k=2 → [2,1,4,3,5]
 */
public class ReverseInGroups {

    /**
     * Same pattern as {@link ReverseInPairs}:
     * reverse this group first, then attach tail directly to recursive result.
     */
    public static Link reverseKGroup(Link head, int k) {
        Link node = head;
        int count = 0;

        while (node != null) {
            node = node.next;
            count++;
            if (count == k) {
                break;
            }
        }

        if (count < k) {
            return head;
        }

        // reverse k nodes: prev = new head, head = tail, node = start of rest
        Link prev = null;
        Link curr = head;
        for (int i = 0; i < k; i++) {
            Link next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // direct attach — like ReverseInPairs: tail.next = recursive head
        head.next = reverseKGroup(node, k);

        return prev;
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
        System.out.print("k=2: ");
        printList(reverseKGroup(buildList(1, 2, 3, 4, 5), 2));

        System.out.print("k=3: ");
        printList(reverseKGroup(buildList(1, 2, 3, 4, 5), 3));

        System.out.print("k=3 (odd tail): ");
        printList(reverseKGroup(buildList(1, 2, 3, 4), 3));
    }
}
