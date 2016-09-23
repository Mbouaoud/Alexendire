package org.dta.alexendrie.service;

import java.util.List;
import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.core.Model;

public interface GenericService<T extends Model> {
	
	public JpaRepository<T> getRepository();
	
	public default T save(T t){
		T check;
		check =	getRepository().save(t);
		return check;
	}
	
	public default void remove(T t){
		getRepository().delete(t);
	}
	
	public default T getById(long id){
		return getRepository().findOne(id);
	}
	
	public default List<T> getAll(){
		return getRepository().findAll();
	}
}