package snakeLadder;

public class Client {
	public static void main(String[] args) {
		Player player1 = new Player("Anmol");
		Player player2 = new Player("Gudia");
		SnakeLadder game = new SnakeLadder(player1, player2);
		player1.setCell(game.getBoard().getCell(1));
		player2.setCell(game.getBoard().getCell(1));
		game.play();
	}

}
