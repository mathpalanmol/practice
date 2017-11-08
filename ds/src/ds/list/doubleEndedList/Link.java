
package ds.list.doubleEndedList;

/**
 * @author Anmol.m
 */
public class Link {
  int key;
  Link next;
	
	public Link(int key) {
		this.key = key;
	}
	
	public void display(){
		System.out.println(key);
	}

}
