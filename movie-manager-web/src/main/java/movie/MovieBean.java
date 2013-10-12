package movie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.naming.NamingException;

import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.IMovieManager;

@ManagedBean(name = "movieBean")
@RequestScoped
public class MovieBean {
	private String result;
	private String title;
	private String author;
	private Integer year;
	private String category;
	private String language;

	@Inject
	private IMovieManager movieManager;
	
	public void search(ActionEvent actionEvent) throws NamingException {
		Movie movie = movieManager.findByTitle(getTitle());

		if (movie != null) {
			this.result = "found.";
	        this.title = movie.getTitle();
	        this.year = movie.getYear();
	        this.author = movie.getAuthor().getName();
	        this.category = movie.getCategory().getName();
	        this.language = movie.getLanguage();
		} else {
			this.result = "not found.";
		}
	}
	
	public String getResult() {
		return result;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }
}
