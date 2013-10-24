package movie;

public class MockView implements MovieView {
	private String matches;
	private boolean notFound;

	@Override
	public String getMatches() {
		return matches;
	}

	@Override
	public void setMatches(String matches) {
		this.matches = matches;
	}

	@Override
	public void notifyNotFound() {
		notFound = true;
	}

	public boolean isNotFound() {
		return notFound;
	}
}
