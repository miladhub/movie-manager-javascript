package movie;

import java.util.List;

public interface MovieRepository {
	Movie findByTitle(String title);
	List<Movie> findAll();
}
