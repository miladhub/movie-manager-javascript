package movie;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import movie.j2ee.interfaces.MovieRepository;

@ServerEndpoint("/ws")
public class MovieEndpoint implements MovieView {
	@Inject
	private MovieRepository model;
	private MoviePresenter presenter;
	private Session session;

	@PostConstruct
	public void createPresenter() {
		presenter = new MoviePresenter(this, model);
	}

	@OnOpen
	public void open(Session session) {
		this.session = session;
	}

	@OnMessage
	public void search(String query) throws IOException, EncodeException {
		presenter.search(query);
	}

	@Override
	public void displayMatches(String matches) {
		try {
			session.getBasicRemote().sendText(matches);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void displayErrorMessage(String error, String detail) {
		try {
			session.getBasicRemote().sendText(error + " (" + detail + ")");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}