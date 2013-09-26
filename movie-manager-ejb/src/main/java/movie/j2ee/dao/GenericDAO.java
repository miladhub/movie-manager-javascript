package movie.j2ee.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	public T findById(ID id);
	
	public List<T> findAll();
	
	public T update(T entity);
    
    public void create(T entity);

    public void delete(T entity);

    public void flush();

    public void clear();
}
