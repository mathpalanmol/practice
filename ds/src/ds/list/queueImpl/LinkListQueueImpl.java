package ds.list.queueImpl;



public class LinkListQueueImpl {

	/**
	 * @author - anmol.m
	 */
	public static void main(String[] args) {
		LinkQueue linkQueue = new LinkQueue();
		System.out.println("Stack Implementation via LinkList");
		System.out.println("Queue is empty: " + linkQueue.isEmpty());
		linkQueue.insertLast(1);/* First In */
		linkQueue.insertLast(2);
		linkQueue.insertLast(3);
		linkQueue.insertLast(4);
		linkQueue.insertLast(5);

		linkQueue.displayQueueElements();
		System.out.println("Queue is empty: " + linkQueue.isEmpty());
		linkQueue.deleteFirst(); /* First out */
		linkQueue.displayQueueElements();

		linkQueue.deleteFirst();
		linkQueue.displayQueueElements();

		linkQueue.deleteFirst();
		linkQueue.displayQueueElements();

		System.out.println("Queue is empty: " + linkQueue.isEmpty());

		linkQueue.deleteFirst();
		linkQueue.displayQueueElements();

		linkQueue.deleteFirst();
		linkQueue.displayQueueElements();

		System.out.println("Queue is empty: " + linkQueue.isEmpty());

	}

}
