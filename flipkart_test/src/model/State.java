package model;

public class State {
	public String name;
	public State next;
	public State start;

	public State(String name) {
		super();
		this.name = name;
		start = this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getNext() {
		return next;
	}

	public void setNext(State next) {
		this.next = next;
	}

	public State getStart() {
		return start;
	}

	public void setStart(State start) {
		this.start = start;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((State) obj).name);
	}

	@Override
	public String toString() {
		return "State [name=" + name + "]";
	}

}
