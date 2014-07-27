package movie;

public class FindMovies {
	private FindMovieResponder responder;
	private MovieRepository repository;

	public FindMovies(FindMovieResponder responder, MovieRepository repository) {
		this.responder = responder;
		this.repository = repository;
	}

	public void search(String searchCriteria) {
		Movie movie = repository.findByTitle(searchCriteria);
		if (movie != null) {
			responder.matchesFound(movie);
		} else {
			responder.noMatchesFoundForCriteria(searchCriteria);
		}
	}
}
