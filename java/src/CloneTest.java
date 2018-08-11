import java.util.ArrayList;
import java.util.List;

public class CloneTest implements Cloneable {
	String str;
	List<Integer> list = new ArrayList<Integer>();

	CloneTest(String str) {
		this.str = str;
	}

	public void populateList() {
		list.add(1);
		list.add(2);
	}
	 public List<Integer> getList(){
		 return list;
	 }

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneTest obj = new CloneTest("anmol");
		System.out.println(obj.str);
		obj.populateList();
		
		System.out.println("Before clone");
		for(Integer value : obj.getList())
			System.out.println(value);
		CloneTest clonedObject = (CloneTest) obj.clone();
		System.out.println("cloned: " + clonedObject.str);
		
		System.out.println("After clone");
		for(Integer value : clonedObject.getList())
			System.out.println(value);
	}

}
