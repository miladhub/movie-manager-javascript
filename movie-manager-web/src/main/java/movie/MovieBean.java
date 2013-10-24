package movie;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import movie.j2ee.interfaces.MovieFinder;

@Named
@RequestScoped
public class MovieBean implements MovieView {
	@Inject
	private MovieFinder movieManager;
	private String matches, searchCriteria;
	private MoviePresenter presenter;
	
	@PostConstruct
	public void createPresenter() {
		presenter = new MoviePresenter(this, movieManager);
	}
	
	public void search(ActionEvent actionEvent) {
		presenter.search(searchCriteria);
	}
	
	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

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
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not found!", "You looked for: " + searchCriteria));
	}
}
