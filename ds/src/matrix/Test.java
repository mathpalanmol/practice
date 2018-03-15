package matrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

//interface, class and method 
//It can't be applied on abstract variable, method and constructor
//it is used to achieve consistency in floating point calculations across different platforms 
public class Test {

	public static void main(String... args) {
		Person p1 = new Person(20);
		Person p2 = new Person(25);
		Person p3 = new Person(22);
		System.out.println(System.currentTimeMillis());
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		for (Person person : list)
			System.out.println(person.age);
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}

		});
		System.out.println();
		for (Person person : list)
			System.out.println(person.age);
		
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		PriorityQueue pq = new PriorityQueue<>();
		LinkedList ll = new LinkedList<Integer>();
		System.out.println(System.currentTimeMillis());
//		Date d = new Date(System.currentTimeMillis());

		
	}

}

class Person {
	int age;

	public Person(int age) {
		super();
		this.age = age;
	}

}