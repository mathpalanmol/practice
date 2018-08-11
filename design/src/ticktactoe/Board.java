package ticktactoe;

public class Board {
	private Cell[][] board;
	
	
	// maintain a q of available cells

	public Board() {
		board = new Cell[3][3];
		createBoard(board);
	}

	private void createBoard(Cell[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new Cell(Mark.NONE);
			}
		}

	}

	Cell[][] getCells() {
		return board;
	}
	
	Cell getAvailableCells() {
		//TODO RETURN ALL AVAILABLE CELL
		return null;
	}
	
	Cell getAvailableCell() {
		// return top of queue
		return null;
	}
	// create location class and pass it along with player
	void makeMove(Player player, Cell cell) {
		// remove form q
	}
	
	//display board method
}
