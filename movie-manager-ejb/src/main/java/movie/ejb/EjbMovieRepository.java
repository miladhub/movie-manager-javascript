package movie.ejb;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import movie.Movie;
import movie.MovieEvent;

@Stateless
public class EjbMovieRepository implements LocalMovieRepository {
	@Inject
	private MovieDao movieDao;
	@Inject
    private Event<MovieEvent> movieEvent;

	@Override
	public Movie findByTitle(String title) {
		movieEvent.fire(new MovieEvent(title));
		return movieDao.findByTitle(title);
	}
}
