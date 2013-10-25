package movie;

public interface MovieView {
	String getMatches();
	void matchesFound(String matches);
	void noMatchesFound();
	boolean isMatchesShown();
}
