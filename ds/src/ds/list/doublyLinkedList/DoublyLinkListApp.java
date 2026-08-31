package ds.list.doublyLinkedList;

public class DoublyLinkListApp {

	/**
	 * @author: Anmol.m
	 */
	public static void main(String[] args) {
			DoublyLinkList linkList = new DoublyLinkList();
			linkList.insertLast(1);
			linkList.insertLast(2);
			linkList.insertLast(3);
			linkList.insertLast(4);
			linkList.insertLast(5);
			linkList.insertLast(6);
			linkList.insertLast(7);
			linkList.insertLast(8);
			linkList.displayForward();
			
			//tested
			Link root  = linkList.linkToBinary(linkList.first, 8);
//			Link root  = linkList.linkToBinary(linkList.first);
			inOrder(root);

          
       		
	}

	private static void inOrder(Link root) {
		if(root == null)
			return;
		
		inOrder(root.previous);
		System.out.print(root.key + ", ");
		inOrder(root.next);
		
	}	

}
