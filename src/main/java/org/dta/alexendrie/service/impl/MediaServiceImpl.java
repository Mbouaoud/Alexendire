package org.dta.alexendrie.service.impl;

import java.util.List;

import org.dta.alexendrie.core.JpaRepository;
import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.repository.LoanRepository;
import org.dta.alexendrie.repository.MediaRepository;
import org.dta.alexendrie.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mediaService")
public class MediaServiceImpl implements MediaService{
	
	@Autowired private MediaRepository mediaRepository;

	@Override
	public List<Media> getMediaAll() {
		return mediaRepository.findAll();
	}

	@Override
	public List<Media> getMediaByTitle() {
		return null;
	}
	
	@Override	
	public JpaRepository getRepository() {
		return mediaRepository;
	}
}