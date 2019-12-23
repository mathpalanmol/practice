package service;

public class CabDistance {
	Cab cab;
	int distance;

	public CabDistance(Cab cab, int distance) {
		super();
		this.cab = cab;
		this.distance = distance;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "CabDistance [cab=" + cab + ", distance=" + distance + "]";
	}

}
