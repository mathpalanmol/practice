package app.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Seat {
	private String seatNo;
	private int price;
	private Boolean isBlocked;
	List<Seat> available;
	List<Seat> booked;

	public Seat(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

}
