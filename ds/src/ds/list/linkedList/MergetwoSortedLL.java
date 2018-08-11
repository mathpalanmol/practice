package ds.list.linkedList;

public class MergetwoSortedLL {
	public static void main(String[] args) {
		LinkList list1 = new LinkList();
		list1.insertElement(5); /* Insertion */
		list1.insertElement(7);
		list1.insertElement(9);

		LinkList list2 = new LinkList();
		list2.insertElement(6); /* Insertion */
		list2.insertElement(8);
		list2.insertElement(10);
		list1.insertElement(12);
		Link start = mergeIterative(list1.first, list2.first);
		display(start);
	}

	private static void display(Link start) {
		Link current = start;
		while (current != null) {
			System.out.println(current.key);
			current = current.next;
		}

	}

	/* Recursive */
	static Link mergeLists(Link list1, Link list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)   //similar to lca
			return list1;

		if (list1.key <= list2.key) {
			list1.next = mergeLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeLists(list1, list2.next);
			return list2;
		}
	}
	/* Iterative */

	static Link mergeIterative(Link link1, Link link2) {
		Link start = null;
		Link current = null;
		while (link1 != null && link2 != null) {
			if (link1.key <= link2.key) {
				if (start == null) {
					start = link1;
					current = link1;
				} else {
					current.next = link1;
					current = current.next;
				}
				link1 = link1.next;
			} else {
				if (start == null) {
					start = link2;
					current = link2;
				} else {
					current.next = link2;
					current = current.next;
				}
				link2 = link2.next;
			}
			
		} // same approach we use while merging
		if (link1 != null) {
			current.next = link1;
			link1 = link1.next;
			current = current.next;
		}
		if (link2 != null) {
			current.next = link2;
			link2 = link2.next;
			current = current.next;
		}

		return start;
	}

}
