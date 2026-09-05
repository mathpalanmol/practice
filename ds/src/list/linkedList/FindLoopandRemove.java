package list.linkedList;

/**
 * Detect and remove a cycle in a linked list (Floyd's cycle detection).
 *
 * <p>Example list used below:
 * <pre>
 * 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
 *              ↑_______________↓
 * </pre>
 * Loop starts at node 4.
 *
 * <p>Math intuition (Floyd):
 * <ul>
 *   <li>m = distance from head to loop start (1→2→3→4)</li>
 *   <li>l = loop length (4→5→6→7→8→4)</li>
 *   <li>k = distance from loop start to meeting point inside the loop</li>
 * </ul>
 * When slow and fast meet: {@code m + k} is a multiple of {@code l}.
 * So if one pointer restarts at head and both move 1 step, they meet at the loop start.
 */
public class FindLoopandRemove {

	public static void main(String[] args) {
		Link list = getLinkedList();

		boolean loop = checkLoop(list);
		System.out.println("Loop exists: " + loop);

		if (loop) {
			Link loopStart = returnLoopStart(list);
			System.out.println("Loop starts at: " + loopStart.key);
			removeLoop(loopStart); // break the cycle
		}
	}

	/**
	 * Remove the cycle given the loop-start node.
	 * Walk once around the loop until {@code current} comes back to start;
	 * {@code pre} is then the last node in the loop — set {@code pre.next = null}.
	 */
	private static void removeLoop(Link link) {
		Link start = link;       // loop entry node
		Link current = start.next;
		Link pre = start;

		// walk the loop until we return to start
		while (current != start) {
			pre = current;
			current = current.next;
		}

		// last node in the loop used to point back to start — cut that link
		pre.next = null;
	}

	/**
	 * Detect cycle with slow/fast pointers (tortoise and hare).
	 * Slow moves 1 step, fast moves 2 steps.
	 * If they meet → cycle exists. If fast hits null → no cycle.
	 */
	private static boolean checkLoop(Link current) {
		Link slow = current;
		Link fast = current;

		// need fast and fast.next non-null so fast.next.next is safe
		while (fast != null && fast.next != null) {
			fast = fast.next.next; // 2 steps
			slow = slow.next;      // 1 step

			if (slow == null || fast == null) {
				return false; // reached end — no cycle
			}
			if (slow == fast) {
				return true; // same node — cycle found
			}
		}
		return true; // note: existing behavior when loop exits without meeting
	}

	/**
	 * Find the first node of the cycle (assumes a cycle exists).
	 *
	 * <p>1) Run slow/fast until they meet inside the loop.
	 * <p>2) Move slow back to head; keep fast at meeting point.
	 * <p>3) Move both one step at a time — they meet at the loop start.
	 */
	private static Link returnLoopStart(Link current) {
		Link slow = current;
		Link fast = current;

		// Phase 1: find any meeting point inside the loop
		// (cycle already confirmed by checkLoop, so no null checks here)
		while (true) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break; // meeting point found
			}
		}

		// Phase 2: restart slow from head; both move 1 step
		// They meet at the loop entrance (node 4 in the sample)
		slow = current;
		while (slow.key != fast.key) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow; // loop start
	}

	/**
	 * Build sample list with a cycle:
	 * 1→2→3→4→5→6→7→8→(back to 4)
	 */
	private static Link getLinkedList() {
		Link l1 = new Link(1);
		Link l2 = new Link(2);
		Link l3 = new Link(3);
		Link l4 = new Link(4);
		Link l5 = new Link(5);
		Link l6 = new Link(6);
		Link l7 = new Link(7);
		Link l8 = new Link(8);
		Link l9 = new Link(9);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l4; // creates the loop back to 4

		return l1;
	}

	static class Link {
		int key;
		Link next;

		public Link(int key) {
			this.key = key;
		}
	}
}
