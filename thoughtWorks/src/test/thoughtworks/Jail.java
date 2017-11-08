package test.thoughtworks;

public class Jail implements CellIfc {
	int position;
	int value;

	public Jail(int value) {
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
