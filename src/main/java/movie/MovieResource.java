package movie;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/movies")
public class MovieResource {
	@Inject
	private MovieRepository model;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Movie> findAll() {
		System.out.println("findAll");
		return model.findAll();
	}

	@GET @Path("search/{query}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Movie findByName(@PathParam("query") String query) {
		System.out.println("findByName: " + query);
		return model.findByTitle(query);
	}
}
