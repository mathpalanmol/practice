package immutable;

// For immutability mark class as final.
// mark variables as private and don't provide public getter method.

//Advantage:
// Immutable objects are thread safe.

public final class ImmutableStudent {
	private final int id;
	private final String name;
	private final Age age;

	// y we are not initializing and creating new object.
	// reason: let say we assign then if age attribute changes it will reflect in
	// immutableStudent also.
	// that's y while initialzing we are creating new object.
	public ImmutableStudent(int id, String name, Age age) {
		this.name = name;
		this.id = id;
		Age cloneAge = new Age();
		cloneAge.setDay(age.getDay());
		cloneAge.setMonth(age.getMonth());
		cloneAge.setYear(age.getYear());
		this.age = cloneAge;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		return age;
	}
}

class Age {
	private int day;
	private int month;
	private int year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
