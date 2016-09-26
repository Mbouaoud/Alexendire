package org.dta.alexendrie.repository;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Usr;

public interface UsrRepository extends JpaRepository<Usr>{

	public Usr findByLogin(String login);
}
