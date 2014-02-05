package movie;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import movie.j2ee.ejb.entity.Author;
import movie.j2ee.ejb.entity.Movie;

import org.junit.Before;
import org.junit.Test;

public class MoviePresenterTest {
	private final MovieView view = mock(MovieView.class);
	private final StubModel model = new StubModel();
	private final MoviePresenter presenter = new MoviePresenter(view, model);

	@Before
	public void addFakeMovie() {
		Movie myMovie = new Movie();
		myMovie.setTitle("My Movie");
		Author a = new Author();
		a.setName("PKDick");
		myMovie.setAuthor(a);
		myMovie.setYear(2010);
		model.add(myMovie);
	}
	
	@Test
	public void thereAreInitiallyNoMatches() throws Exception {
		assertFalse(presenter.shouldShowMatches());
	}
	
	@Test
	public void searchShouldDisplayMatches() throws Exception {
		presenter.search("My Movie");
		verify(view).displayMatches("PKDick, 'My Movie' (2010)");
	}
	
	@Test
	public void matchesAppearWhenSomethingIsFound() throws Exception {
		presenter.search("My Movie");
		assertTrue(presenter.shouldShowMatches());
	}
	
	@Test
	public void userIsNotifiedWhenNothingIsFound() throws Exception {
		presenter.search("my other movie");
		verify(view).displayErrorMessage("Not found, sorry!", "You looked for: my other movie");
	}
}
