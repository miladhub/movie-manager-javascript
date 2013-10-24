package movie;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class MoviePresenterTest {
	private MockView view = new MockView();
	private MockModel model = new MockModel();
	
	private MoviePresenter presenter = new MoviePresenter(view, model);

	@Before
	public void stubs() {
	}
	
	@Test
	public void detailsAreInitiallyEmpty() throws Exception {
		assertNull(view.getMatches());
	}
	
	@Test
	public void searchShouldCallTheModelAndDisplayResults() throws Exception {
		presenter.search("my movie");
		assertThat(view.getMatches(), is("PKDick, 'My Movie' (2010)"));
	}
	
	@Test
	public void userIsNotifiedWhenNothingIsFound() throws Exception {
		assertFalse(view.isNotFound());
		presenter.search("my other movie");
		assertTrue(view.isNotFound());
	}
}
