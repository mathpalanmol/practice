package battleship;

import java.util.Random;

public abstract class Ship {
	Location location;
	int length;
	Direction dir; // not been used. just setting it after given position get validated in place ship
					// method.
	int hitCount;
	boolean destroyed;// or sunk

	public Ship(int length) {
		super();
		this.length = length;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
// range is matrix row/col length
	public Location fire(int range) {
		Random random = new Random();
		return new Location(random.nextInt(range), random.nextInt(range));
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

}
