package lift;

import java.util.Collections;
import java.util.PriorityQueue;

public class Elevator {
	enum Direction {
		UP, DOWN, STATIONARY
	};

	PriorityQueue<Integer> qUp = new PriorityQueue<Integer>(); // min
	PriorityQueue<Integer> qDown = new PriorityQueue<Integer>(Collections.reverseOrder()); // max
	PriorityQueue<Integer> current = null;
	private int currentFloor;
	private int minFloor;
	private int maxFloor;
	private Direction currentDir;

	public Elevator(int minFloor, int maxFloor) {
		super();
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
		execute();
	}

	private void execute() {
		current = qUp;
		while (true) {

			while (qUp.size() != 0) {
				currentDir = Direction.UP;
				moveUp(qUp.poll());
			}

			current = qDown;
			while (qDown.size() != 0) {
				currentDir = Direction.DOWN;
				moveDown(qDown.poll());
			}
			current = qUp;

			if (qUp.size() == 0 && qDown.size() == 0)
				currentDir = Direction.STATIONARY;

		}
	}

	public void registerRequestFromOutside(Integer target, Direction dir) {
		if (target > currentFloor && (dir == Direction.UP || dir == Direction.STATIONARY)) {
			qUp.add(target);
		}else if (target < currentFloor && (dir == Direction.DOWN || currentDir == Direction.STATIONARY)) {
			qDown.add(target);
		} else if (target > currentFloor && (dir == Direction.DOWN || currentDir == Direction.STATIONARY)) {
			qDown.add(target);
		}else {
			//target < currentFloor && (dir == Direction.UP || dir == Direction.STATIONARY)
			qUp.add(target);
		}
		
	}
	
	// more conditions need to be added

	public void registerRequestFromInside(Integer target) {
		if (target > currentFloor && currentDir == Direction.UP) {
			qUp.add(target);
		} else if (target < currentFloor && currentDir == Direction.DOWN) {
			qDown.add(target);
		}
	}

	private void moveDown(Integer destFloor) {
		if (destFloor < minFloor)
			new IllegalArgumentException();
		while (currentFloor != destFloor) {
			currentFloor--;
		}

	}

	private void moveUp(Integer destFloor) {
		if (destFloor > maxFloor)
			new IllegalArgumentException();
		while (currentFloor != destFloor) {
			currentFloor++;
		}
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

}
