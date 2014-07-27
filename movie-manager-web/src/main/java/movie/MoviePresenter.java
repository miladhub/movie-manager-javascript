package movie;

public class MoviePresenter implements FindMovieResponder {
	private final MovieView view;
	private final FindMovies interactor;
	private boolean shouldShowMatches;

	public MoviePresenter(MovieView view, MovieRepository repository) {
		this.view = view;
		this.interactor = new FindMovies(this, repository);
	}

	public void search(String searchCriteria) {
		interactor.search(searchCriteria);
	}

	public boolean shouldShowMatches() {
		return shouldShowMatches;
	}

	@Override
	public void matchesFound(Movie movie) {
		view.displayMatches(movie.getAuthor().getName() + ", '" + movie.getTitle() + "' (" + movie.getYear() + ")");
		this.shouldShowMatches = true;
	}

	@Override
	public void noMatchesFoundForCriteria(String searchCriteria) {
		view.displayErrorMessage("Not found, sorry!", "You looked for: " + searchCriteria);
	}
}
