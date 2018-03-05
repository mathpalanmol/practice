package app.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private String name;
	private static List<City> cities;

	public Country() {
		cities = new ArrayList<City>();
	}

	public void addCity(City city) {
		cities.add(city);
	}

	public void addcities(List<City> cities) {
		for (City city : cities) {
			addCity(city);
		}
	}

	public List<City> getCities() {
		return cities;
	}

	public String getName() {
		return name;
	}
}
