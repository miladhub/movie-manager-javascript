package movie;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import movie.j2ee.interfaces.MovieRepository;

@Named
@RequestScoped
public class MovieBean implements MovieView {
	@Inject
	private MovieRepository model;
	private MoviePresenter presenter;
	private String matches, searchCriteria;
	
	@PostConstruct
	public void createPresenter() {
		presenter = new MoviePresenter(this, model);
	}
	
	public void search(ActionEvent actionEvent) {
		presenter.search(searchCriteria);
	}
	
	@Override
	public void matchesFound(String matches) {
		this.matches = matches;
	}
	
	@Override
	public void noMatchesFound() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not found!", "You looked for: " + searchCriteria));
	}
	
	public String getSearchCriteria() {
		return searchCriteria;
	}
	
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	public boolean isMatchesShown() {
		return presenter.shouldShowMatches();
	}
	
	public String getMatches() {
		return matches;
	}
}
