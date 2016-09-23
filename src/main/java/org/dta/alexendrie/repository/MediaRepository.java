package org.dta.alexendrie.repository;

import java.util.List;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.model.MediaType;

public interface MediaRepository extends JpaRepository<Media>{

	List<Media> findMediaBy(String titre, String auteur, MediaType type);

	
}