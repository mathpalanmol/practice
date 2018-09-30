package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class HashTest implements Comparable<HashTest>{
	String name;
	int id;
	int uid;
	
	

	public HashTest(String name, int id, int uid) {
		super();
		this.name = name;
		this.id = id;
		this.uid = uid;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 13;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.id == ((HashTest)obj).id;
	}

	public static void main(String[] args) {
		HashTest o1= new HashTest("A",2,1);
		HashTest o2= new HashTest("B",1,2);
		System.out.println(o1);
		System.out.println(o2);
		
		System.out.println(o1==o2);
		HashSet<HashTest> set = new HashSet<HashTest>();
		set.add(o1);
		set.add(o2);
		System.out.println(set.size());
		
		ArrayList<HashTest> list = new ArrayList<HashTest>();
		list.add(o1);
		list.add(o2);
		
		//Collections.sort(list, new Com1());
		Collections.sort(list);
		System.out.println("Sorted by id");
		for(HashTest obj : list)
			System.out.println(obj.name);
//		Collections.sort(list, new Com2());
//		System.out.println("Sorted by uid");
//		for(HashTest obj : list)
//			System.out.println(obj.name);
	}

	@Override
	public int compareTo(HashTest o) {
		return this.id-o.id;
	} 
}


class Com1 implements Comparator<HashTest>{

	@Override
	public int compare(HashTest o1, HashTest o2) {
		return o1.id - o2.id;
		
	}
	
}


class Com2 implements Comparator<HashTest>{

	@Override
	public int compare(HashTest o1, HashTest o2) {
		return o1.uid - o2.uid;
		
	}
	
}





























