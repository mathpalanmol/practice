package snakeLadder;

import java.util.Random;

public class SnakeLadder {
	private Board board;
	private Player player1;
	private Player player2;

	public SnakeLadder(Player player1, Player player2) {
		this.board = new Board();
		this.player1 = player1;
		this.player2 = player2;

	}

	public void play() {
		Player player = player1;
		while (true) {
			System.out.println("Player: " + player.getName() + " is playing.");
			System.out.println("Initial Count: " + player.getCell().getId());
			int count = rollDice(player.getCell().getId());
			System.out.println("Dice count: " + count);
			if (count + player.getCell().getId() <= 100) {
				Cell destCell = board.getCell(count + player.getCell().getId());
				System.out.println("Total Count: " + destCell.getId());
				Mark mark = getCellStatus(destCell);
				System.out.println("Destination Cell mark: " + mark);
				if (mark.equals(Mark.NONE))
					player.setCell(destCell);
				else {
					player.setCell(destCell.getDestination());
					System.out.println("New destination: " + destCell.getDestination().getId());
				}
				if (isWinner(player)) {
					System.out.println("Player: " + player.getName() + " is winner");
					break;
				}
			}
			if (player == player1)
				player = player2;
			else
				player = player1;
			System.out.println("\n************************\n");
			// just to better debug sleep is introduced.
//			 try {
//			 Thread.sleep(1000);
//			 } catch (InterruptedException e) {
//			 // TODO Auto-generated catch block
//			 e.printStackTrace();
//			 }
		}

	}

	private boolean isWinner(Player player) {
		if (player.getCell().getId() == 100)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	private Mark getCellStatus(Cell cell) {
		return cell.getMark();
	}

	private int rollDice(int id) {
		Random random = new Random();
		int count = 0;
		while (count == 0) { // if the random calcuated no is zero we need to calcuate again. dice doesn't
								// have 0.
			count = random.nextInt(7); // it will give a random no between 0 to 6 both including
		}
		return count;
	}

	public Board getBoard() {
		return board;
	}

}
