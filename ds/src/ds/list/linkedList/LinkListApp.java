package ds.list.linkedList;

public class LinkListApp {

	/**
	 * @author: anmol.m
	 * @category: LinkList Operations:- Insertion, Search, Deletion
	 * @serialData: Friday, Januray 27, 2012
	 */

	public static void main(String[] args) {
		LinkList theLink = new LinkList();
		theLink.insertElement(2); /* Insertion */
		theLink.insertElement(3);
		theLink.insertElement(4);
		theLink.insertElement(5);
		theLink.insertElement(6);
		theLink.insertElement(7);
		theLink.insertElement(8);

		theLink.displayList();
		
		theLink.reverse(theLink.first);
		theLink.displayList();
		
//		theLink.removeDuplicates(theLink.first);
//		theLink.displayList();
//		System.out.println("First: " + theLink.first.key);
//		ReplaceWithLeastGreatest obj = new ReplaceWithLeastGreatest();
//		Link output = obj.getList(theLink.first);
//		while (output != null) {
//			System.out.println(output.key);
//			output = output.next;
//		}
		// System.out.println("Recursion ");
		// theLink.reverse(theLink.first);
		// Link head = theLink.first;
		// while(head !=null){
		// System.out.println(head.key);
		// head = head.next;
		// }
		// System.out.println("Iteration: ");
		// Link head = theLink.reverseI(theLink.first);
		// while(head!=null){
		// System.out.println(head.key);
		// head = head.next;
		// }

		// System.out.println(theLink.first.key);
		//
		// Link searchedLink = theLink.find(6); /*Searching*/
		// if (searchedLink != null) {
		// System.out.println("Search link contains: " + searchedLink.key);
		// } else {
		// System.out.println("Link is not available for the search.");
		// }
		// Link deletedLink = theLink.delete(2); /*Deletion*/
		// if(deletedLink != null){
		// System.out.println(deletedLink.key + " is deleted from the list.");
		// }
		// else{
		// System.out.println("Given link is not there in the list");
		// }
		// theLink.displayList();
	}

}
