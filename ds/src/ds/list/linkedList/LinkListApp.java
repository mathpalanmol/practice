package ds.list.linkedList;

public class LinkListApp {

	/**
	 * @author: anmol.m
	 * @category: LinkList Operations:- Insertion, Search, Deletion
	 * @serialData: Friday, Januray 27, 2012
	 */
	
	public static void main(String[] args) {
		LinkList theLink = new LinkList();
		theLink.insertElement(1); /*Insertion*/
		theLink.insertElement(2);
		theLink.insertElement(3);
		theLink.insertElement(4);
		theLink.insertElement(5);

		theLink.displayList();
		System.out.println("Recursion ");
        theLink.reverse(theLink.first);
        Link head = theLink.first;
		while(head !=null){
			System.out.println(head.key);
			head = head.next;
		}
//		System.out.println("Iteration: ");
//		Link head = theLink.reverseI(theLink.first);
//		while(head!=null){
//			System.out.println(head.key);
//			head = head.next;
//		}
		
//		System.out.println(theLink.first.key);
//
//		Link searchedLink = theLink.find(6); /*Searching*/
//		if (searchedLink != null) {
//			System.out.println("Search link contains: " + searchedLink.key);
//		} else {
//			System.out.println("Link is not available for the search.");
//		}
//		Link deletedLink = theLink.delete(2); /*Deletion*/
//        if(deletedLink != null){
//        	System.out.println(deletedLink.key + " is deleted from the list.");
//        }
//        else{
//        	System.out.println("Given link is not there in the list");
//        }
//    	theLink.displayList();
	}

}
