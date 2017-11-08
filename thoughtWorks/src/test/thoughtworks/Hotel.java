package test.thoughtworks;

public class Hotel implements CellIfc {
	int position;
	boolean isOwned;
	Player owner;
	int value;
	int rent;

	public Hotel(int value, int rent) {
		super();
		this.value = value;
		this.rent = rent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		isOwned = true;
		this.owner = owner;
	}

}
