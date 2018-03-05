package app.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class City {
	private String name;
	private List<Movie> movies;

	public City(String name) {
		this.name = name;
		movies = new ArrayList<Movie>();
	}

	public List<Movie> getMovieList() {
		return movies;
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
	}

	public void addList(List<Movie> movies) {
		for (Movie movie : movies) {
			addMovie(movie);
		}
	}

	public String getName() {
		return name;
	}

}
