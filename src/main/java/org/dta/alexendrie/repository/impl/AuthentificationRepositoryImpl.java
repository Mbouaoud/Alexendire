package org.dta.alexendrie.repository.impl;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Usr;
import org.dta.alexendrie.repository.AuthentificationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuthentificationRepositoryImpl extends JpaRepositoryImpl<Usr>implements AuthentificationRepository {

	@Override
	protected Class<Usr> getEntityClass() {		return Usr.class;	}

	public Boolean findUsrbyLogin(String login, String password) {

		Boolean usrFind = false;
		String query = "Select u from Usr u where login='" + login + "'";

		try {
			Usr usrResearch = findFirst(query);
			if (usrResearch.getPassword().equals(password)) {
				usrFind = true;
			} else
				usrFind = false;
		} catch (NullPointerException e) {
			usrFind = false;
		}

		return usrFind;
	}
}
