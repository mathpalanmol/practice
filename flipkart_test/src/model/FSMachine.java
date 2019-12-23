package model;

import java.util.List;

public class FSMachine {
	private String name;
	private State start;

	public FSMachine(String name) {
		super();
		this.name = name;
		start = new State("Initial");
	}

	public void addState(List<State> stateList) {
		for (State state : stateList)
			addState(state);
	}

	public void addState(State state) {
		State pre = null;
		State current = start;
		while (current != null) {
			pre = current;
			current = current.next;
		}
		pre.next = state;
	}

	public State getInitialState() {
		return start;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "FSMachine [name=" + name + ", start=" + start + "]";
	}

}
