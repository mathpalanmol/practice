//http://www.cis.upenn.edu/~matuszek/cit591-2013/Assignments/10-battleship.html

//https://codereview.stackexchange.com/questions/162174/oop-battleship-implementation-in-java-part-2

/*The computer places the ten ships on the ocean in such a way that no ships are immediately adjacent to each other, either horizontally, vertically, or diagonally. For example,

Legal arrangement
Illegal--ships diagonally adjacent
Illegal--ships horizontally adjacent
	 	 	 	 	 	 	 	 	 
	S	S	S	 	 	S	 	 	 
	 	 	 	 	 	S	 	 	S
S	 	S	S	S	 	 	 	 	S
	 	 	 	 	 	 	 	 	 
	S	S	 	S	 	 	S	 	 
	 	 	 	 	 	 	 	 	S
	 	 	 	 	 	 	 	 	S
	 	 	 	 	 	 	 	 	S
S	 	 	 	 	 	 	 	 	S
The human player does not know where the ships are. The initial display of the ocean shows a 10 by 10 array of locations, all the same.

The human player tries to hit the ships, by calling out a row and column number. The computer responds with one bit of information--hit" or "miss." When a ship is hit but not sunk, the program does not provide any information about what kind of a ship was hit. However, when a ship is hit and sinks, the program prints out a message "You just sank a ship-type." After each shot, the computer redisplays the ocean with the new information.

A ship is "sunk" when every square of the ship has been hit. Thus, it takes four hits (in four different places) to sink a battleship, three to sink a cruiser, two for a destroyer, and one for a submarine. The object is to sink the fleet with as few shots as possible; the best possible score would be 20. (Low scores are better.) When all ships have been sunk, the program prints out a message that the game is over, and tells how many shots were required.
*/
package battleship;

public class Game {
	static OceanBoard board = new OceanBoard(10, 10);

	public static void main(String[] args) {
		BattleShip bsa = new BattleShip(4);
		Cruser cra = new Cruser(3);
		Destroyer dsa = new Destroyer(2);
		SubMarine sua = new SubMarine(1);

		BattleShip bsb = new BattleShip(4);
		Cruser crb = new Cruser(3);
		Destroyer dsb = new Destroyer(2);
		SubMarine sub = new SubMarine(1);

		Player playerA = new Player("A");
		playerA.registerShip(bsa);
		playerA.registerShip(cra);
		playerA.registerShip(dsa);
		playerA.registerShip(sua);

		Player playerB = new Player("B");
		playerB.registerShip(bsb);
		playerB.registerShip(crb);
		playerB.registerShip(dsb);
		playerB.registerShip(sub);

		board.placeShip(playerA.getShips().get(0), Direction.H);
		board.placeShip(playerA.getShips().get(1), Direction.V);
		board.placeShip(playerA.getShips().get(2), Direction.H);
		board.placeShip(playerA.getShips().get(3), Direction.V);

		board.placeShip(playerB.getShips().get(0), Direction.H);
		board.placeShip(playerB.getShips().get(1), Direction.H);
		board.placeShip(playerB.getShips().get(2), Direction.H);
		board.placeShip(playerB.getShips().get(3), Direction.V);

		start(playerA, playerB);
	}

	private static void start(Player playerA, Player playerB) {
		// start with player A
		Player currentPlayer = playerA;
		// while current player holds any ship. We can also place this condition at the
		// end and break out of loop.
		// by keeping while(true)
		while (currentPlayer.getShipCount() > 0) {
			// get the ship randomly among the player un-destroyed ships
			Ship ship = currentPlayer.getRandomShip();
			Location pos = ship.fire(board.getOcean().length); // ship may fire itself or same player ships.//todo
																// validation checks must be provide in fire method.
			// set the fire count of player. at the end it will give us total fire count..
			// incase we want to print it
			currentPlayer.setFireCount(currentPlayer.getFireCount() + 1);
			// get the ship at fired location
			Ship destShip = board.getShip(pos);
			System.out.println(currentPlayer.name + " Ship Count: " + currentPlayer.getShipCount());
			// check if fire hits the target
			if (!(destShip instanceof NoShip)) {
				// it's a hit. get the hit count
				int count = destShip.getHitCount() + 1;
				// remove the current instance of ship. removed same instance of ship is shared
				// across the length in boardocean.
				board.removeShip(pos);
				// increment the hitcount by 1
				destShip.setHitCount(count);
				if (count == destShip.getLength()) { // when all parts are destroyed
					destShip.setDestroyed(Boolean.TRUE);
					currentPlayer.setShipCount(currentPlayer.getShipCount() - 1);
				}
			}
			System.out.println(currentPlayer.name + " Ship Count: " + currentPlayer.getShipCount());
			// swap the players
			if (currentPlayer == playerA)
				currentPlayer = playerB;
			else
				currentPlayer = playerA;
//			board.printBoard();

		}
		System.out.println("******* Game Over *******");
		if (playerA.getShipCount() == 0)
			System.out.println("Player B wins the game.");
		else
			System.out.println("Player A wins the game.");
	}
}
