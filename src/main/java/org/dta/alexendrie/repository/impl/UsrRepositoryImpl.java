package org.dta.alexendrie.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Usr;
import org.dta.alexendrie.repository.UsrRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsrRepositoryImpl extends JpaRepositoryImpl<Usr> implements UsrRepository{

	@Override
	protected Class<Usr> getEntityClass() {
		return Usr.class;
	}

	@Override
	public Usr findByLogin(String login) {
		return findFirst("select u from Usr u where u.login='"+login+"'");
	}
}