package ds.list.doublyLinkedList;

public class DoublyLinkListApp {

	/**
	 * @author: Anmol.m
	 */
	public static void main(String[] args) {
			DoublyLinkList linkList = new DoublyLinkList();
			linkList.insertFirst(1);
			linkList.insertFirst(2);
			linkList.insertFirst(3);
//			linkList.insertFirst(4);
//			linkList.insertFirst(5);
			linkList.displayForward();
			
//			linkList.deleteFirst();
//			linkList.displayForward();
//			
//			linkList.deleteLast();
//			linkList.displayForward();
//			
//            linkList.deleteKey(3);
//            linkList.displayForward();
//
//            linkList.deleteKey(5);
//            linkList.displayForward();
//
//            linkList.deleteKey(1);
//            linkList.displayForward();
//			
//			linkList.insertAfter(4, 41);
//			linkList.displayForward();
//			linkList.insertAfter(41, 42);
//			linkList.displayForward();
//			linkList.displayBackward();
			
			
			linkList.linkToBinary();

          
       		
	}

}
