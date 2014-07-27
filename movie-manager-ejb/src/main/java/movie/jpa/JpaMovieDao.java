package movie.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import movie.Movie;
import movie.ejb.MovieDao;

public class JpaMovieDao implements MovieDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Movie findByTitle(String title) {
		try {
			Query q = em.createNamedQuery("movie-findByTitle");
			q.setParameter("title", title);
			return (Movie) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
