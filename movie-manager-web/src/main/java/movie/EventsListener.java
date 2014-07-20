package movie;

import java.io.Serializable;

import javax.enterprise.event.Observes;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import movie.j2ee.ejb.session.MovieEvent;

@Named
@SessionScoped
public class EventsListener implements Serializable {
	private static final long serialVersionUID = 1L;
	private String last;

	public void onFinderCalled(@Observes MovieEvent event) {
		this.last = event.getTitle();
		if (FacesContext.getCurrentInstance() != null) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Finder has been called on movie " +
	        		event.getTitle(), event.getTitle()));
		}
    }

	public void update() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Last movie was " +
        		last, last));
	}

	public String getLast() {
		return last;
	}
}
