package movie.ejb;

import javax.ejb.Local;

import movie.Movie;

@Local
public interface MovieDao {
	Movie findByTitle(String title);
}
