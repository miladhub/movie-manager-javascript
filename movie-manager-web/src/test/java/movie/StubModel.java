package movie;

import java.util.HashMap;
import java.util.Map;

import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.MovieRepository;

public class StubModel implements MovieRepository {
	private Map<String, Movie> moviesByTitle = new HashMap<String, Movie>();
	
	public void add(Movie movie) {
		moviesByTitle.put(movie.getTitle(), movie);
	}

	@Override
	public Movie findByTitle(String title) {
		return moviesByTitle.get(title);
	}
}
