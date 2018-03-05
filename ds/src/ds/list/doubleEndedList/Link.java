
package ds.list.doubleEndedList;

/**
 * @author Anmol.m
 */
public class Link {
  public int key;
  public Link next;
	
	public Link(int key) {
		this.key = key;
	}
	
	public void display(){
		System.out.println(key);
	}

}
