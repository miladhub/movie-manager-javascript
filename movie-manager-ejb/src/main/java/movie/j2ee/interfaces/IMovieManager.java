package movie.j2ee.interfaces;

import movie.j2ee.ejb.entity.Movie;

public interface IMovieManager {
	Movie findByTitle(String title);
}
