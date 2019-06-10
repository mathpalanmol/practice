package restaurant;

import java.util.Date;
import java.util.List;

public class BookingManager {
	
	public static void main(String[] args) {
		int guest = 10;
		Restaurant res = new Restaurant("Delhi", 11, 23);
		List<Table> tables = res.getTables(new Date(System.currentTimeMillis()), new Slot(7, 10), guest);
		if(tables == null) {
		  System.out.println("Can't accomodate guest count: " + guest);
		}
		boolean isBooked = res.bookTable(new Date(System.currentTimeMillis()),new Slot(7, 10), tables);
		if(isBooked) {
			System.out.println("Table is booked succcessfully.");
		}else {
			System.out.println("Can't book right now. Please book later.s");
		}
	
	}

}
