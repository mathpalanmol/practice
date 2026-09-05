package list.linkedList;

public class LinkListApp {

	/**
	 * @author: anmol.m
	 * @category: SinglyLinkedList Operations:- Insertion, Search, Deletion, Reverse
	 * @serialData: Friday, January 27, 2012
	 */

	public static void main(String[] args) {
		SinglyLinkedList theLink = new SinglyLinkedList();
		theLink.insertElement(2); /* Insertion */
		theLink.insertElement(3);
		theLink.insertElement(4);
		theLink.insertElement(5);
		theLink.insertElement(6);
		theLink.insertElement(7);
		theLink.insertElement(8);

		System.out.println("Original:");
		theLink.displayList();

		theLink.reverseRecursive();
		System.out.println("After reverseRecursive:");
		theLink.displayList();
	}

}
