package list.linkedList;

/**
 * Add Two Numbers (LeetCode #2)
 *
 * <p>Two linked lists represent non-negative integers in reverse order
 * (least significant digit first). Add them and return the sum as a linked list.
 *
 * <p>Examples:
 * <pre>
 * 2 -> 4 -> 3   (342)
 * 5 -> 6 -> 4   (465)
 * ---------------
 * 7 -> 0 -> 8   (807)
 *
 * 0
 * 0
 * ---
 * 0
 *
 * 9 -> 9 -> 9 -> 9   (9999)
 * 9 -> 9             (99)
 * ------------------
 * 8 -> 9 -> 0 -> 1   (10098)
 * </pre>
 */
public class AddTwoNumbers {

    /**
     * Add digit by digit with carry, like elementary addition.
     */
    public static Link addTwoNumbers(Link l1, Link l2) {
        Link dummy = new Link(0);
        Link tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.key;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.key;
                l2 = l2.next;
            }

            carry = sum / 10;
            tail.next = new Link(sum % 10);
            tail = tail.next;
        }

        return dummy.next;
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
        System.out.print("342 + 465 = ");
        printList(addTwoNumbers(buildList(2, 4, 3), buildList(5, 6, 4)));

        System.out.print("0 + 0 = ");
        printList(addTwoNumbers(buildList(0), buildList(0)));

        System.out.print("9999 + 99 = ");
        printList(addTwoNumbers(buildList(9, 9, 9, 9), buildList(9, 9)));

        System.out.print("5 + 5 = ");
        printList(addTwoNumbers(buildList(5), buildList(5)));
    }
}
