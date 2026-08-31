package ds.list.stackImpl;

public class LinklistStackImpl {
	public static void main(String[] args) {
		LinkStack linkStack = new LinkStack();
		System.out.println("Stack Implementation via LinkList");
		System.out.println("Tree is empty: " + linkStack.isEmpty());
		linkStack.insertFirst(1);/* First In */
		linkStack.insertFirst(2);
		linkStack.insertFirst(3);
		linkStack.insertFirst(4);
		linkStack.insertFirst(5);
		
		System.out.println("Tree is empty: " + linkStack.isEmpty());
		linkStack.displayStackElements();
		
		linkStack.deleteFirst(); /* Last out s*/ 
		linkStack.displayStackElements();
		
		linkStack.deleteFirst();
		linkStack.displayStackElements();
		
		linkStack.deleteFirst();
		linkStack.displayStackElements();
		
		System.out.println("Tree is empty: " + linkStack.isEmpty());
		
		linkStack.deleteFirst();
		linkStack.displayStackElements();
		
		linkStack.deleteFirst();
		linkStack.displayStackElements();
		
		System.out.println("Tree is empty: " + linkStack.isEmpty());

	}

}
