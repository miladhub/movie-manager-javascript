package movie;

import static org.junit.Assert.*;

import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class MoviePresenterTest {
	@Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

	private final MovieView view = context.mock(MovieView.class);
	private final MovieRepository repo = context.mock(MovieRepository.class);
	private final MoviePresenter presenter = new MoviePresenter(view, repo);

	@Test
	public void thereAreInitiallyNoMatches() throws Exception {
		assertFalse(presenter.shouldShowMatches());
	}
}
