package taxiBookingSystem.model;

public class VechileAvailabiltyDetails {
	int availableCount;
	int busyCount;

	public VechileAvailabiltyDetails(int availableCount, int busyCount) {
		super();
		this.availableCount = availableCount;
		this.busyCount = busyCount;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public int getBusyCount() {
		return busyCount;
	}

	public void setBusyCount(int busyCount) {
		this.busyCount = busyCount;
	}

	@Override
	public String toString() {
		return "VechileAvailabiltyDetails [availableCount=" + availableCount + ", busyCount=" + busyCount + "]";
	}

}
