package service;


public class Passenger {
	Cordinates cordinates;

	public Passenger(int x, int y) {
		cordinates = new Cordinates(x, y);
	}

	public Cordinates getCordinates() {
		return cordinates;
	}

}
