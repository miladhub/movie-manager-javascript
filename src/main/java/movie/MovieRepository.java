package movie;

public interface MovieRepository {
	Movie findByTitle(String title);
}
