package movie.files;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import movie.Movie;
import movie.MovieEvent;

@Stateless
public class FileSystemMovieRepository implements LocalMovieRepository {
	@Inject
    private Event<MovieEvent> movieEvent;
    private File moviesFolder;

	@PostConstruct
	private void setUpHomeFolder() {
	    moviesFolder = new File(System.getProperty("user.home"), ".movies");
	}
	
	@Override
	public Movie findByTitle(String title) {
		movieEvent.fire(new MovieEvent(title));
		File movieFile = new File(moviesFolder, title + ".xml");
        if (!movieFile.exists()) {
		    return null;
		}
		try {
            return unmarshal(FileUtils.readFileToString(movieFile));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
	}

    private Movie unmarshal(String contents) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Movie.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Unmarshaller um = context.createUnmarshaller();
            return (Movie) um.unmarshal(new StringReader(contents));
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }
}
