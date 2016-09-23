package org.dta.alexendrie.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Usr;
import org.dta.alexendrie.repository.AuthentificationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthentificationRepositoryImpl extends JpaRepositoryImpl<Usr>implements AuthentificationRepository {

	@Override
	protected Class<Usr> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean findUsrbyLogin(String login, String password) {

		Boolean usrFind = false;
		String query = "Select u from Usr m where login='" + login + "'";
		Usr usrResearch = findFirst(query);

		if (usrResearch.getPassword().equals(password)) {
			usrFind = true;
		}

		return usrFind;

	}

}
