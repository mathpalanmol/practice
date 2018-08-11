package battleship;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player {
	
	String name;
	List<Ship> ships;
	Random random = new Random();
	int fireCount; // just to track firecount
	int shipCount;

	public Player(String name) {
		super();
		this.name = name;
		this.ships = new LinkedList<Ship>();
	}

	void registerShip(Ship ship) {
		ships.add(ship);
		shipCount += 1;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public Ship getRandomShip() {
		Ship ship = null;
		while (true) {
			ship = ships.get(random.nextInt(ships.size()));
			if (!ship.destroyed)
				break;
		}
		return ship;
	}

	public int getFireCount() {
		return fireCount;
	}

	public void setFireCount(int fireCount) {
		this.fireCount = fireCount;
	}

	public int getShipCount() {
		return shipCount;
	}
	public void setShipCount(int shipCount) {
		this.shipCount = shipCount;
	}


}
