package movie;

public interface MovieView {
	String getMatches();
	void setMatches(String matches);
	void notifyNotFound();
}
