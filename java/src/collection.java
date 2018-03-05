import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class collection {

	public static void main(String[] args) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		
//		 map.put("sd", 1);
//		 map.put("fd", 2);
//		 map.put("gh", 3);
//		 map.put("bs", 4);
//		//
//		// map.put(5, 4);
//		// map.put(6, 4);
//		// map.put(7, 4);
//		// map.put(8, 4);
//
//		for (Map.Entry<String, Integer> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + " s " + entry.getValue());
//		}
//		//map that remembers the order of insertion by mainting doublylink list
//		// application : while creating a map using another map
//		// LRU
//		LinkedHashMap<String, Integer> mapl = new LinkedHashMap<String, Integer>();
//		mapl.put("sd", 1);
//		mapl.put("fd", 2);
//		mapl.put("gh", 3);
//		mapl.put("bs", 4);
//		System.out.println("\n\n");
//		 for (Map.Entry<String, Integer> entry : mapl.entrySet()) {
//				System.out.println(entry.getKey() + " s " + entry.getValue());
//			}
//		 System.out.println("\n\n");
//		 Queue<Integer> q = new LinkedList<Integer>();
//		 q.offer(1);
//		 q.offer(2);
//		 q.offer(3);
//		 q.offer(4);
//		 q.offer(5);
//		 while(q.size() != 0)
//			 System.out.println();
		 m1(null); // null.intValue(); in unboxing
		 Number numb = new Integer(2);
		 List<Number> list = new ArrayList<Number>();
		 list.add(numb);

	}
	
	static Integer m1(Integer i){
		if(i==5)
			throw new RuntimeException("Custom error message");
		return i;
		
	}

}
