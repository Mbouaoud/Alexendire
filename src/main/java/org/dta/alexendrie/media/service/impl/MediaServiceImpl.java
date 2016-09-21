package org.dta.alexendrie.media.service.impl;

import org.dta.alexendrie.media.repository.MediaRepository;
import org.dta.alexendrie.media.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mediaService")
public class MediaServiceImpl implements MediaService{
	@Autowired private MediaRepository mediaRepository;
}