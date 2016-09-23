package org.dta.alexendrie.repository;

import java.util.List;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Media;

public interface MediaRepository extends JpaRepository<Media> {

	List<Media> findUsrByLogin();
}