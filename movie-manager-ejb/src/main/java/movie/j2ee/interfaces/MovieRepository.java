package movie.j2ee.interfaces;

import movie.j2ee.ejb.entity.Movie;

public interface MovieRepository {
	Movie findByTitle(String title);
}
