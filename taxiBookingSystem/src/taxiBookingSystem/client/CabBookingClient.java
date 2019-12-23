package taxiBookingSystem.client;

import taxiBookingSystem.enums.Category;
import taxiBookingSystem.model.Agency;
import taxiBookingSystem.model.Point;
import taxiBookingSystem.model.User;
import taxiBookingSystem.model.UserManagement;
import taxiBookingSystem.model.Vechile;
import taxiBookingSystem.service.BookingService;

public class CabBookingClient {
	public static void main(String[] args) {
		User user1 = new User(1);
		User user2 = new User(1);
		
		UserManagement users = new UserManagement();
		users.addUser(user1);
		users.addUser(user2);

		Vechile v1 = new Vechile(1, Category.MINI, 10);
		Vechile v2 = new Vechile(1, Category.SUV, 20);
		Vechile v3 = new Vechile(1, Category.SEDAN, 30);

		Agency agency = new Agency(1, "TestAgency");
		agency.registerVechile(v1);
		agency.registerVechile(v2);
		agency.registerVechile(v3);

		BookingService bookingService = new BookingService();
		bookingService.setUserManagement(users);
		bookingService.registerAgency(agency);

		Point p1 = new Point(1, 2);
		Point p2 = new Point(2, 3);
		int fare = bookingService.getFare(p1, p2, Category.MINI);
		System.out.println("fare: " + fare);

	}
}
