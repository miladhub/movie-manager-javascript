package movie;

import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.MovieFinder;

public class MoviePresenter {
	private final MovieView view;
	private final MovieFinder model;

	public MoviePresenter(MovieView view, MovieFinder model) {
		this.view = view;
		this.model = model;
	}

	public void search(String searchCriteria) {
		Movie movie = model.findByTitle(searchCriteria);
		if (movie != null) {
			view.setMatches(movie.getAuthor().getName() + ", '" + movie.getTitle() + "' (" + movie.getYear() + ")");
		} else {
			view.notifyNotFound();
		}
	}
}
