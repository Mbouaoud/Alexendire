package org.dta.alexendrie.core;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hibernate.Session;

public abstract class JpaRepositoryImpl<T extends Model> implements JpaRepository<T>{
	protected Class<T> entityClass;
	
	@PersistenceContext EntityManager em;
	
	@PostConstruct    public void init() {        
		entityClass = getEntityClass();    
	}
	
	protected abstract Class<T> getEntityClass();
	
	@Transactional
	public Session getSession() {		
		return em.unwrap(Session.class);	
	}

	@Transactional
    public T save(T entity) {
        if (isNew(entity)) {
            em.persist(entity);
            return entity;
        } else if (!em.contains(entity)) {
            return em.merge(entity);
        }

        return entity;
    }

	@Transactional
    public T findOne(int id) {
        return em.find(entityClass, id);
    }
	
    @Transactional
    public List<T> findAll() {
        return getSession().createCriteria(entityClass).list();
    }
    
    protected List<T> findBy(String query){
    	return em.createQuery(query).getResultList();
    }
    
    protected T findFirst(String query){
    	List<T> l = findBy(query);
    	
    	if(l==null || l.size()==0){
    		return null;
    	}
    	return l.get(0);
    }
	
    @Transactional
    public void delete(T entity) {
        if (!getSession().contains(entity)) {
            em.remove(getSession().merge(entity));
        } else {
            em.remove(entity);
        }
    }
    
    @Transactional
    public void delete(int id) {
    	T t = findOne(id);
    	
    	if(t==null) return;
    	
        if (!getSession().contains(t)) {
            em.remove(getSession().merge(t));
        } else {
            em.remove(t);
        }
    }

	public boolean isNew(T entity) {       
		return entity.getId() == 0;    
	}
}