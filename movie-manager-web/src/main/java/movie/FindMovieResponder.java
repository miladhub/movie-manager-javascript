package movie;

import movie.j2ee.ejb.entity.Movie;

public interface FindMovieResponder {
	void matchesFound(Movie movie);
	void noMatchesFoundForCriteria(String searchCriteria);
}
