package movie.j2ee.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractGenericDAO<T, ID extends Serializable>
	implements GenericDAO<T, ID> {
	
	private Class<T> entityBeanType;

    private EntityManager em;

	public AbstractGenericDAO(EntityManager em) {
    	this();
    	this.em = em;
    }
    
    @SuppressWarnings("unchecked")
	public AbstractGenericDAO() {
        this.entityBeanType = (Class<T>) ((ParameterizedType) getClass()
                                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    protected EntityManager getEntityManager() {
        if (em == null)
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        return em;
    }

    public Class<T> getEntityBeanType() {
        return entityBeanType;
    }

    public T findById(ID id) {
        return getEntityManager().find(getEntityBeanType(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + getEntityBeanType().getName() ).getResultList();
    }

    public T update(T entity) {
        return getEntityManager().merge(entity);
    }
    
    public void create(T entity) {
    	getEntityManager().persist(entity);
    }

    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void clear() {
        getEntityManager().clear();
    }
	
}
