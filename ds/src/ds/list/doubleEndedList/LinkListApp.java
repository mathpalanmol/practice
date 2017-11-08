package ds.list.doubleEndedList;

public class LinkListApp {

	/**
	 * @author: anmol.m
	 * @category: LinkList Operations:- Insertion, Search, Deletion
	 * @serialData: Friday, Januray 27, 2012
	 */

	public static void main(String[] args) {
		LinkList theLink = new LinkList();
		theLink.insertFirst(1); /* Insertion */
		theLink.insertFirst(2);
		theLink.insertFirst(3);
		theLink.insertFirst(4);
		theLink.insertFirst(5);

		theLink.displayList();
		
//		theLink.deleteFirst();
//		theLink.deleteFirst();
		
		/* This functionality is not a part of double link list */
		theLink.deleteLast();
		theLink.deleteLast();
		theLink.deleteLast();
		theLink.deleteLast();
		theLink.deleteLast();
		
		theLink.displayList();
		

	}

}
