package app.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	String name;
	static List<Theatre> theatres;
	int basePrice;

	public Movie(String name, int basePrice) {
		this.name = name;
		theatres = new ArrayList<Theatre>();
	}

	public String getName() {
		return name;
	}

	public void addTheatre(Theatre theatre) {
		theatres.add(theatre);
	}

	public void setTheatres(List<Theatre> theatres) {
		for (Theatre theatre : theatres) {
			addTheatre(theatre);
		}
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	

}
