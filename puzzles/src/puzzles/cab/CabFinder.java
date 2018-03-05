package puzzles.cab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabFinder {

	public CabFinder(Cab[] cabs) {
		populateCabs(cabs);
	}

	Map<Location, List<Cab>> cabsByLocation = new HashMap<Location, List<Cab>>();
	static HashMap<Cordinates, Location> locationList = new HashMap<Cordinates, Location>();

	List<Cab> getCabsByLocation(Location location) {
		return cabsByLocation.get(location);
	}

	Cab getNearestCab(Passenger passenger) {
		Cordinates passCordinates = passenger.getCordinates();
		Location passlocation = locationList.get(passCordinates);
		List<Cab> cabList = cabsByLocation.get(passlocation);
		Cab cab = getNearestCab(passenger, cabList);
		return cab;
	}

	private Cab getNearestCab(Passenger passenger, List<Cab> cabList) {
		Cordinates pasCord = passenger.getCordinates();
		int minDistance = Integer.MAX_VALUE;
		Cab cab = null;
		for (Cab cabByLocation : cabList) {
			Cordinates cabCord = cabByLocation.getCordinates();
			int distance = calculateDistance(pasCord, cabCord);
			if (distance < minDistance) {
				distance = minDistance;
				cab = cabByLocation;
			}
		}
		return cab;
	}

	private int calculateDistance(Cordinates pasCord, Cordinates cabCord) {
		int x1 = pasCord.x;
		int x2 = cabCord.x;
		int y1 = pasCord.y;
		int y2 = cabCord.y;
		int distance = (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		return distance;
	}

	Location getLocation(Cordinates cordinates) {
		return locationList.get(cordinates);
	}

	void populateCabs(Cab[] cabs) {
		for (Cab cab : cabs) {
			Location location = locationList.get(cab.getCordinates());
			if (cabsByLocation.containsKey(location)) {
				List<Cab> cabList = cabsByLocation.get(location);
				cabList.add(cab);
			} else {
				List<Cab> listcab = new ArrayList<Cab>();
				listcab.add(cab);
				cabsByLocation.put(location, listcab);
			}
		}

	}

	// main
	public static void main(String[] args) {
		CabFinder cabFinder = new CabFinder(getCabs());
		Passenger passenger = new Passenger(2, 3);
		cabFinder.getNearestCab(passenger);
	}

	static Cab[] getCabs() {
		Cab[] cabAry = new Cab[6];
		Cab cab1 = new Cab(2, 3);
		Cab cab2 = new Cab(4, 5);
		Cab cab3 = new Cab(6, 7);
		Cab cab4 = new Cab(2, 6);
		Cab cab5 = new Cab(1, 2);
		Cab cab6 = new Cab(2, 2);
		cabAry[0] = cab1;
		cabAry[1] = cab2;
		cabAry[2] = cab3;
		cabAry[3] = cab4;
		cabAry[4] = cab5;
		cabAry[5] = cab6;
		return cabAry;
	}
}

class Location {
	String name;
	String id;
}

class Cab {
	Cordinates cordinates;

	public Cab(int x, int y) {
		cordinates = new Cordinates(x, y);
	}

	public Cordinates getCordinates() {
		return cordinates;
	}
}

class Passenger {
	Cordinates cordinates;

	public Passenger(int x, int y) {
		cordinates = new Cordinates(x, y);
	}

	public Cordinates getCordinates() {
		return cordinates;
	}

}

class Cordinates {
	int x;
	int y;

	public Cordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
