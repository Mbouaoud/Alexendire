package org.dta.alexendrie.repository.impl;

import java.util.List;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.repository.MediaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MediaRepositoryImpl extends JpaRepositoryImpl<Media>implements MediaRepository {

	@Override
	protected Class<Media> getEntityClass() {
		return Media.class;
	}

	public List<Media> findUsrByLogin() {

		return null;

	}
}