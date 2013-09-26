package movie.j2ee.dao;

import movie.j2ee.ejb.entity.Movie;

public interface IMovieDAO extends GenericDAO<Movie, Long> {
	public Movie findByTitle(String title);
}
