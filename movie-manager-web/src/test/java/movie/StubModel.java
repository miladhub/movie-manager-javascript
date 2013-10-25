package movie;

import java.util.HashMap;
import java.util.Map;

import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.MovieFinder;

public class StubModel implements MovieFinder {
	private Map<String, Movie> movies = new HashMap<String, Movie>();
	
	public void add(Movie movie) {
		movies.put("my movie", movie);
	}

	@Override
	public Movie findByTitle(String title) {
		return movies.get(title);
	}
}
