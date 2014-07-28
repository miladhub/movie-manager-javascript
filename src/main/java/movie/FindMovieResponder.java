package movie;


public interface FindMovieResponder {
	void matchesFound(Movie movie);
	void noMatchesFoundForCriteria(String searchCriteria);
}
