package movie;

import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.NamingException;

import movie.j2ee.ejb.entity.Movie;
import movie.j2ee.interfaces.IMovieManager;
import movie.j2ee.interfaces.RemoteMovieManager;

@ManagedBean(name = "movieBean")
@RequestScoped
public class MovieBean {
	private String result;
	private String title;
	private String author;
	private Integer year;
	private String category;
	private String language;

	public void search(ActionEvent actionEvent) throws NamingException {
		IMovieManager movieManager = lookup();

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

	private RemoteMovieManager lookup() {
		final Hashtable<String, Object> props = new Hashtable<String, Object>();
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = null;
		try {
			context = new javax.naming.InitialContext(props);
			return (RemoteMovieManager) context.lookup("ejb:" + "slave" + "/" + "movie-manager-ejb-1.0.0-SNAPSHOT" + "/" + "" + "/" +
					"MovieManagerSessionBean" + "!" + "movie.j2ee.interfaces.RemoteMovieManager");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (context != null) {
					context.close();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return null;
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
