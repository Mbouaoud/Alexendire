package org.dta.alexendrie.core;

import java.util.List;

import org.hibernate.Session;

public interface JpaRepository<T extends Model> {

	public Session getSession();

	public T save(T entity);

	public T findOne(long id);

	public List<T> findAll();

	public void delete(T entity);

	public void delete(long id);

	public boolean isNew(T entity);

	public List<T> findBy(String query);

	public T findFirst(String query);
}