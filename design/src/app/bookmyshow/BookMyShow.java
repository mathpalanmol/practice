package app.bookmyshow;

import java.util.ArrayList;
import java.util.List;

//Design backend system for bookMyShow.com like system which supports below use cases: 

//1) When user selects country, list of cities is displayed. 
//2) When user selects city, movie list is displayed. 
//3) When user selects movie, list of theatre is displayed. 
//4) When user selects theatre, show timing is displayed. 
//5) When show timing is selected, user is asked for no of seats that he wants to book 
//6) When user selects no of seats, seats are displayed to choose from. 
//7) When user selects seats, then total price is displayed. 
//8) When total price is selected, then user is directed to payment gateway and payment is done and on payment success, ticket is mailed to him. 

public class BookMyShow {

	public BookMyShow() {}

	public static void main(String[] args) {
		BookMyShow ref = new BookMyShow();
		User user = new User("Ashok", "ashok@example.com");
		ref.bookTicket(user);
	}

	private void bookTicket(User user) {
		Country india = new Country();
		City delhi = new City("Delhi");
		City bangalore = new City("Bangalore");
		City hyderabad = new City("Hyderabad");
		india.addCity(delhi);
		india.addCity(bangalore);
		india.addCity(hyderabad);

		Theatre theatre1 = new Theatre("PVR", 50, new String[] { "9 AM", "2 PM", "6 PM" });
		Theatre theatre2 = new Theatre("Inorbit", 60, new String[] { "9 AM", "1:30 PM", "5 PM", "8:30 PM" });
		Theatre theatre3 = new Theatre("Central", 70, new String[] { "10 AM", "2 PM", "7 PM" });
		Movie troy = new Movie("Troy", 200);
		delhi.addMovie(troy);
		bangalore.addMovie(troy);
		hyderabad.addMovie(troy);
		
		troy.addTheatre(theatre1);
		troy.addTheatre(theatre2);
		troy.addTheatre(theatre3);

		List<City> cities = india.getCities(); // list of cities
		City city = cities.get(0); // select one city can be of any available index
		List<Movie> movies = city.getMovieList();
		Movie movie = movies.get(0);// select one movie
		List<Theatre> theatres = movie.getTheatres();
		Theatre theatre = theatres.get(0); // select a theatre
		String[] timeSlots = theatre.getTimings();
		List<Seat> availableSeats = theatre.showAvailableSeats(timeSlots[0]);// 9 AM
		List<Seat> selectSeat = new ArrayList<Seat>();
		selectSeat.add(availableSeats.get(0));
		selectSeat.add(availableSeats.get(1));
		int amount = theatre.blockSeat(timeSlots[0], selectSeat);
		boolean isSuccecss = payment(amount);
		if (isSuccecss)
			sendMail(user.getMailId());

	}

	private void sendMail(String mailId) {
		System.out.println("Mail is sent to " + mailId);

	}

	public Boolean payment(int Price) {
		System.out.println("Payment is done:");
		return Boolean.TRUE;
	}

}
