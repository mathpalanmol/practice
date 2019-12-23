package service;

public class Cab {
	CabType cabType;
	Cordinates cordinates;
	int distance;

	public Cab(CabType cabType, int x, int y) {
		this.cordinates = new Cordinates(x, y);
		this.cabType = cabType;
	}

	public Cordinates getCordinates() {
		return cordinates;
	}
}
