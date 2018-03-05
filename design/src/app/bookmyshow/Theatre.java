package app.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theatre {
	private String name;
	List<Movie> movies;
	Integer seatsCount;
	String[] timings;
	Map<String, List<Seat>> mAvailable = new HashMap<String, List<Seat>>();
	Map<String, List<Seat>> mBooked = new HashMap<String, List<Seat>>();

	public Theatre(String name, Integer seatsCount, String[] timings) {
		this.name = name;
		this.seatsCount = seatsCount;
		this.timings = timings;
		populate();
	}

	private void populate() {
		for (int j = 0; j < timings.length; j++) {
			List<Seat> available = new ArrayList<Seat>();
			List<Seat> booked = new ArrayList<Seat>();
			for (int i = 0; i < seatsCount; i++) {
				Seat seat = new Seat(String.valueOf(i));
				available.add(seat);
			}
			mAvailable.put(timings[j], available);
			mBooked.put(timings[j], booked);
		}
	}

	public String getName() {
		return name;
	}

	public synchronized Integer blockSeat(String timeSlot, List<Seat> requestList) {
		int price = 0;
		for (Seat seat : requestList) {
			price = price + seat.getPrice();
			List<Seat> available = mAvailable.get(timeSlot);
			available.remove(seat);
			List<Seat> blocked = mBooked.get(timeSlot);
			blocked.add(seat);
		}
		return price;
	}

	public synchronized List<Seat> showAvailableSeats(String timeSlot) {
		List<Seat> list = mAvailable.get(timeSlot);
		return list;
	}

	public List<Seat> getSeats(String timeSlot) {
		return mAvailable.get(timeSlot);
	}

	public int getAvailSeatsCount(String timeSlot) {
		return mAvailable.size();
	}

	public String[] getTimings() {
		return timings;
	}

}
