package movie;

import java.util.HashMap;
import java.util.Map;

import movie.j2ee.ejb.entity.Author;
import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.MovieFinder;

public class MockModel implements MovieFinder {
	@SuppressWarnings("serial")
	private Map<String, Movie> movies = new HashMap<String, Movie>() {{
		Movie m = new Movie();
		m.setTitle("My Movie");
		Author a = new Author();
		a.setName("PKDick");
		m.setAuthor(a);
		m.setYear(2010);
		put("my movie", m);
	}};

	@Override
	public Movie findByTitle(String title) {
		return movies.get(title);
	}

}
