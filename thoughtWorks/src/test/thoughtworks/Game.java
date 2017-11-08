package test.thoughtworks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Game implements GameIfc {
	Board board;
	static char[] chAry = { 'E', 'E', 'J', 'H', 'E', 'T', 'J', 'T', 'E', 'E', 'H', 'J', 'T', 'H', 'E', 'E', 'J', 'H',
			'E', 'T', 'J', 'T', 'E', 'E', 'H', 'J', 'T', 'H', 'J', 'E', 'E', 'J', 'H', 'E', 'T', 'J', 'T', 'E', 'E',
			'H', 'J', 'T', 'E', 'H', 'E' };
	static int[] ptr = { 4, 4, 4, 6, 7, 8, 5, 11, 10, 12, 2, 3, 5, 6, 7, 8, 5, 11, 10, 12, 2, 3, 5, 6, 7, 8, 5, 11, 10,
			12 };
	public int playerCount;
	private static final int BOARD_SIZE = 45;
	// private static final int TURNS = 10;
	private static final String ADD = "ADD";
	private static final String SUB = "SUB";
	List<Player> players = new ArrayList<Player>();

	public Game(int playerCount, String[] playerNames) {
		populateBoard(BOARD_SIZE);
		this.playerCount = playerCount;
		initialize(playerCount, playerNames);
	}

	private void populateBoard(int boardSize) {
		CellIfc[] cells = new CellIfc[boardSize];
		int counter = 0;
		for (char ch : chAry) {
			switch (ch) {
			case 'E':
				cells[counter] = new Empty(0);
				break;
			case 'J':
				cells[counter] = new Jail(150);
				break;
			case 'H':
				cells[counter] = new Hotel(200, 50);
				break;
			case 'T':
				cells[counter] = new Treasure(200);
				break;
			}
			counter++;
		}
		board = new Board(cells);

	}

	private void initialize(int playerCount, String[] playerNames) {
		for (int i = 0; i < playerCount; i++) {
			Player player = new Player(playerNames[i], 0, 1000);
			players.add(player);
		}

	}

	@Override
	public void play() {
		int playerNo = 0;
		for (int i = 0; i < ptr.length; i++) {// total no of turns e.g. for 3 players count is 30
			Player player = players.get(playerNo);
			int playerPointer = player.getPlayer_ptr();
			int moveCount = ptr[i];
			int newPtrIndex = playerPointer + moveCount;
			if (newPtrIndex >= 45)
				continue;
			CellIfc cell = board.getCell(newPtrIndex);
			execute(cell, player);
			playerNo++;
			if (playerNo == playerCount){
				playerNo = 0; // player = player % playerCount;
				}

		}
		printOutput(players);
	}

	private void printOutput(List<Player> players) {
		PriorityQueue<Player> pq = new PriorityQueue<Player>(new Comparator<Player>() {

			public int compare(Player p1, Player p2) {
				return p2.getPlayerCurrentBalance() - p1.getPlayerCurrentBalance();
			}

		});
		for(Player player  : players){
			pq.add(player);
		}
		print(pq);
	}

	private void print(PriorityQueue<Player> pq) {
		for(Player player : pq){
			System.out.println(player.getPlayerName() + " has total worth " + player.getPlayerCurrentBalance());
		}
		
	}

	private void execute(CellIfc cell, Player player) {
		if (cell instanceof Jail) {
			update(player, 150, SUB);
		} else if (cell instanceof Treasure) {
			update(player, 200, ADD);
		} else if (cell instanceof Empty) {
			update(player, 0, ADD);
		} else {// Hotel
			boolean isOwned = isOwned(cell, player);
			Hotel hotel = (Hotel)cell;
			if (!isOwned) {
				update(player, 200, SUB);
				hotel.setOwner(player);
			    player.addHotel(hotel);
				
			} else {
				Player hotelOwner = hotel.getOwner();
				update(player, hotel.getRent(), SUB);
				update(hotelOwner, 50, ADD);
			}
		}

	}

	private boolean isOwned(CellIfc cell, Player player) {
		Hotel hotel = (Hotel) cell;
		if (player.getHotels().contains(hotel))
			return true;
		return false;
	}

	private void update(Player player, int amount, String operation) {
		if (ADD.equals(operation)) {
			player.addBalance(amount);
		} else {// substract
			player.subBalance(amount);
		}

	}
	
	
	public static void main(String[] args) {
		String[] ary = {"p1","p2", "p3"};
		Game game = new Game(3, ary);
		game.play();
	}

}
