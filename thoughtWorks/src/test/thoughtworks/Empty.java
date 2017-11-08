package test.thoughtworks;

public class Empty implements CellIfc {
	int position;
	int value;

	public Empty(int value) {
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
