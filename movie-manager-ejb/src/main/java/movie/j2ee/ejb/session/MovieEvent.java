package movie.j2ee.ejb.session;

public class MovieEvent {
	private String title;
	public MovieEvent(String title) {
		super();
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
}
