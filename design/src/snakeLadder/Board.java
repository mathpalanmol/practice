package snakeLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
	Map<Integer, Cell> cells = new HashMap<Integer, Cell>();

	public Board() {
		init();
	}

	private void init() {
		for (int i = 1; i <= 100; i++) {
			Cell cell = new Cell(i);
			cells.put(i, cell);
		}
		setladder();
		setSnake();
	}
	
	private void setSnake() {
		Cell src1 = cells.get(98);
		Cell dest1 = cells.get(2);
		src1.setSnake(dest1); // snake 1
		
		Cell src2 = cells.get(70);
		Cell dest2 = cells.get(20);
		src2.setSnake(dest2); // snake 2
		
		Cell src3 = cells.get(82);
		Cell dest3 = cells.get(22);
		src3.setSnake(dest3); // snake 3
		
	}

	private void setladder() {
		Cell src1 = cells.get(8);
		Cell dest1 = cells.get(72);
		src1.setLadder(dest1); // ladder 1
		
		Cell src2 = cells.get(22);
		Cell dest2 = cells.get(90);
		src2.setLadder(dest2); // ladder 2
		
		Cell src3 = cells.get(42);
		Cell dest3 = cells.get(76);
		src3.setLadder(dest3); // ladder 3
		
	}

	Cell getCell(int id) {
		return cells.get(id);
	}
}
