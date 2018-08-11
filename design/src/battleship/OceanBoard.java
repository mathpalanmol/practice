package battleship;

import java.util.Random;

public class OceanBoard {
	Ship[][] ocean;

	public OceanBoard(int width, int length) {
		ocean = new Ship[width][length];
		init();
	}

	private void init() {
		for (int i = 0; i < ocean.length; i++) {
			for (int j = 0; j < ocean[0].length; j++) {
				ocean[i][j] = new NoShip(0, 0);
			}
		}

	}
	
	public void printBoard() {
		for (int i = 0; i < ocean.length; i++) {
			for (int j = 0; j < ocean[0].length; j++) {
				System.out.print (ocean[i][j] + " ");// = new NoShip(0, 0);
			}
			System.out.println();
		}
		System.out.println("###################");

	}

	boolean placeShip(Ship ship, Direction dir) { // for list we have to randomly generate direction better user decide
													// it so allowing one ship placemnent at a time.
		Location loc = null;
		boolean validLocation = false;
		//until we get valid position to place ship // this can be lead to infinite loop.
		while (!validLocation) {
			loc = getRandomCordinates();
			validLocation = validateLocation(loc, ship, dir);
		}
		int row = loc.getRow();
		int col = loc.getCol();
		// -1 because ship will occupy current cell
		if (dir.equals(Direction.H)) {
			for (int i = 0; i < col + ship.length - 1; i++) {
				ocean[row][i] = ship; // save same instance in every cell up to length
			}
			ship.setDir(Direction.H);
		}
		if (dir.equals(Direction.V)) {
			for (int i = 0; i < row + ship.length - 1; i++) {
				ocean[i][col] = ship;
			}
			ship.setDir(Direction.V);
		}
		ship.setLocation(loc);
		return true;
	}

	// 1. If ship exceeds the boundary keeping direction in mind.
	// 2. If ship crosses each other.
	private boolean validateLocation(Location loc, Ship ship, Direction dir) {
		int row = loc.getRow();
		int col = loc.getCol();
		// -1 because ship will occupy current cell
		if (((row + ship.getLength() - 1) >= ocean.length && dir == Direction.H)
				|| ((col + ship.getLength()) >= ocean[0].length) && dir == Direction.V) {
			return false;
		}
		// check if it overlaps with other ship
		if (dir.equals(Direction.H)) {
			for (int i = 0; i < col + ship.length - 1; i++) {
				if (!(ocean[row][i] instanceof NoShip)) {
					return false;
				}
			}
		}
		if (dir.equals(Direction.V)) {
			for (int i = 0; i < row + ship.length - 1; i++) {
				if (!(ocean[i][col] instanceof NoShip)) {
					return false;
				}
			}
		}
		return true;
	}

	private Location getRandomCordinates() {
		Random random = new Random();
		return new Location(random.nextInt(ocean.length), random.nextInt(ocean[0].length));
	}

	public Ship getShip(Location loc) {
		return ocean[loc.getRow()][loc.getCol()];
	}

	public void removeShip(Location loc) {
		ocean[loc.getRow()][loc.getCol()] = new NoShip(0, 0);
	}

	public Ship[][] getOcean() {
		return ocean;
	}

}
