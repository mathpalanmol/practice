import java.util.ArrayList;
import java.util.List;



// java default cloning scheme: Shallow Copy

//Whenever we use default implementation of clone method we get shallow copy of object means it creates new instance and copies all the field of object to that new instance and returns it as object type, we need to explicitly cast it back to our original object. This is shallow copy of the object.
//clone() method of the object class support shallow copy of the object. If the object contains primitive as well as nonprimitive or reference type variable in shallow copy, the cloned object also refers to the same object to which the original object refers as only the object references gets copied and not the referred objects themselves.
//That’s why the name shallow copy or shallow cloning in Java. If only primitive type fields or Immutable objects are there then there is no difference between shallow and deep copy in Java.


// In java it's necessary to implement Clonnable otherwise Clonenotsupported exception at runtime.
// obj.clone() // this line will cause exception.

public class CloneTest implements Cloneable{
	String str;
	List<Integer> list =  null; //new ArrayList<Integer>();

	CloneTest(String str) {
		this.list = new ArrayList<Integer>();
		this.str = str;
		list.add(2);
		list.add(3);
	}

	 public List<Integer> getList(){
		 return list;
	 }

// below code is to achieve deep copy	 
//	 @Override
//	protected Object clone() throws CloneNotSupportedException {
//		 CloneTest obj = new CloneTest(this.str);
//		return obj;
//	}

	 // cloning gives you shallow copy
	public static void main(String[] args) throws CloneNotSupportedException {
		System.out.println("Before clone");
		CloneTest obj = new CloneTest("anmol");
		System.out.println(obj.hashCode());
		System.out.println(obj.getList());
		
		System.out.println("After clone");
		CloneTest clonedObject = (CloneTest) obj.clone();
		System.out.println(clonedObject.hashCode());
		System.out.println(clonedObject.getList() == obj.getList());
	}

}

// deep copy example
//A deep copy means actually creating a new array and copying over the values.
//
////Code explaining deep copy 
//public class Ex { 
//   
// private int[] data; 
//
// // altered to make a deep copy of values 
// public Ex(int[] values) { 
//     data = new int[values.length]; 
//     for (int i = 0; i < data.length; i++) { 
//         data[i] = values[i]; 
//     } 
// } 
//
// public void showData() { 
//     System.out.println(Arrays.toString(data)); 
// } 
//} 