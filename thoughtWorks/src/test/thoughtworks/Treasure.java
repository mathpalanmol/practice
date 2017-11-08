package test.thoughtworks;

public class Treasure implements CellIfc{
	int position;
	int value;

	public Treasure(int value) {
		super();
		this.value = value;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
