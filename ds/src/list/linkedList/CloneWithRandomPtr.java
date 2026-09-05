package list.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer (LeetCode #138)
 *
 * <p>A linked list of length n where each node has an extra {@code random} pointer
 * that can point to any node in the list or null.
 *
 * <p>Create a deep copy of the list: new nodes with the same values, and
 * {@code next}/{@code random} pointing to the corresponding new nodes (not the originals).
 *
 * <p>Example:
 * <pre>
 * Original:  1 → 2 → 3 → 4 → 5
 * Random:    1→4, 2→5, 3→5, 4→1, 5→3
 *
 * Clone:     1' → 2' → 3' → 4' → 5'
 * Random:    same structure, all pointers to cloned nodes
 * </pre>
 */
public class CloneWithRandomPtr {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Deep copy using a HashMap: original node → cloned node.
     *
     * <p>Pass 1: create every clone and wire {@code next}.
     * Pass 2: set each clone's {@code random} via the map.
     */
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // original → clone
        Map<Node, Node> map = new HashMap<>();

        // Pass 1: clone nodes and link next pointers
        Node curr = head;
        Node cloneHead = null;
        Node cloneTail = null;

        while (curr != null) {
            Node clone = new Node(curr.val);
            map.put(curr, clone);

            if (cloneHead == null) {
                cloneHead = clone;
                cloneTail = clone;
            } else {
                cloneTail.next = clone;
                cloneTail = clone;
            }
            curr = curr.next;
        }

        // Pass 2: wire random pointers using the map
        curr = head;
        Node cloneCurr = cloneHead;
        while (curr != null) {
            // if original.random is null, clone.random stays null
            if (curr.random != null) {
                cloneCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            String randomVal = (curr.random == null) ? "null" : String.valueOf(curr.random.val);
            System.out.print("[" + curr.val + ", random=" + randomVal + "]");
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    /** Build: 1→2→3→4→5 with random 1→4, 2→5, 3→5, 4→1, 5→3 */
    private static Node buildSampleList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = n4;
        n2.random = n5;
        n3.random = n5;
        n4.random = n1;
        n5.random = n3;

        return n1;
    }

    public static void main(String[] args) {
        Node original = buildSampleList();
        System.out.print("Original: ");
        printList(original);

        Node clone = copyRandomList(original);
        System.out.print("Clone:    ");
        printList(clone);

        // prove deep copy: changing clone does not change original
        clone.val = 99;
        System.out.print("After clone.val=99, original: ");
        printList(original);
    }
}
