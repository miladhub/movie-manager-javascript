package movie;

import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.MovieFinder;

public class MoviePresenter {
	private final MovieView view;
	private final MovieFinder model;
	private boolean shouldShowMatches;

	public MoviePresenter(MovieView view, MovieFinder model) {
		this.view = view;
		this.model = model;
	}

	public void search(String searchCriteria) {
		Movie movie = model.findByTitle(searchCriteria);
		if (movie != null) {
			view.matchesFound(movie.getAuthor().getName() + ", '" + movie.getTitle() + "' (" + movie.getYear() + ")");
			this.shouldShowMatches = true;
		} else {
			view.noMatchesFound();
		}
	}

	public boolean shouldShowMatches() {
		return shouldShowMatches;
	}
}
