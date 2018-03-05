package ds.map;

public class Employee {
	String name;
	int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return 1;

	}

	@Override
	public boolean equals(Object obj) {
		return this.age == ((Employee) obj).age;

	}
	// override hashcode and equals method if you are willing to use this class
	// as key in map.
}
