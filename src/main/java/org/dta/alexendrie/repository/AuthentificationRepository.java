package org.dta.alexendrie.repository;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Usr;

public interface AuthentificationRepository extends JpaRepository<Usr> {
	Boolean findUsrbyLogin(String login, String password);
}