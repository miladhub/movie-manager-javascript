package movie;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
	
	public void search() {
		presenter.search(searchCriteria);
	}
	
	public void validate() {
		if (searchCriteria == null || searchCriteria.length() < 3) {
			displayErrorMessage("Too short man", "Minimum: 3");
		}
	}
	
	@Override
	public void displayMatches(String matches) {
		this.matches = matches;
	}
	
	@Override
	public void displayErrorMessage(String error, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, error, detail));
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
