package ticktactoe;

public class TickTacToe {

	Player player1;
	Player player2;
	Board board;

	public TickTacToe(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		board = new Board();
	}

	public void play() {
		Player current = player1;
		Player winner = null;
		while (true) {
			Location loc = getMove();
			boolean win = checkForWinner();
			if (win) {
				winner = current;
				break;
			}
		}
		System.out.println("Winner is: " + winner.player);

	}

	private boolean checkForWinner() {
		return checkHorizontally() || checkVertically() || checkDiagonally();
	}

	private boolean checkVertically() {
	   Cell[][] cells = board.getCells();
	   for(int col=0; col<cells.length; col++) {
		   if(!(cells[0][col] == cells[1][col])  && cells[1][col]== cells[2][col])
			   return false;
	   }
		return true;
	}

	private boolean checkHorizontally() {
		Cell[][] cells = board.getCells();
		for(int row=0; row<cells.length; row++) {
			   if(!(cells[row][0] == cells[row][1])  && cells[row][1]== cells[row][2])
				   return false;
		   }
			return true;
	}
	
	private boolean checkDiagonally() {
		   Cell[][] cells = board.getCells();
		   for(int i=0; i<cells.length; i++) {
			   for(int j=0; j<cells.length; j++) {
				   
			   }
		   }
		   if(!(cells[0][0] == cells[1][1])  && cells[1][1]== cells[2][2])
			   return false;
		   if(!(cells[0][2] == cells[1][1])  && cells[1][1]== cells[2][0])
			   return false;
			return true;
		}

	// return valid location where mark is NONE
	private Location getMove() {
		return null;
	}

	public static class Location {
		int row;
		int col;

		Location(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}
