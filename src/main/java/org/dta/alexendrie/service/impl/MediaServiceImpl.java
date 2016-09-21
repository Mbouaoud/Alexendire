package org.dta.alexendrie.service.impl;

import org.dta.alexendrie.repository.MediaRepository;
import org.dta.alexendrie.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mediaService")
public class MediaServiceImpl implements MediaService{
	@Autowired private MediaRepository mediaRepository;
}