package ds.list.loopedLinkedList;

public class loopedLinkedListApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		loopedLinkedList loop = new loopedLinkedList();
		loop.insert(1, 1);
		loop.insert(2, 2);
		loop.insert(3, 3);
		loop.insert(4, 4);
		loop.insert(5, 5);
		
		loop.display();
		Boolean isLoop = loop.findLoop();
		System.out.println(isLoop);
		

	}

}
