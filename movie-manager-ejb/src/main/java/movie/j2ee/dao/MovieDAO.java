package movie.j2ee.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import movie.j2ee.ejb.entity.Movie;

public class MovieDAO extends AbstractGenericDAO<Movie, Long> implements IMovieDAO {
	public MovieDAO(EntityManager em) {
		super(em);
	}
	
	@Override
	public Movie findByTitle(String title) {		
		try {
			Query q = getEntityManager().createNamedQuery("movie-findByTitle");
			q.setParameter("title", title);
			return (Movie) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
