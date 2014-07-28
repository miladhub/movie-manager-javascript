package movie.files;

import javax.ejb.Local;

import movie.MovieRepository;

@Local
public interface LocalMovieRepository extends MovieRepository {
}
