package org.dta.alexendrie.service;

import java.util.List;
import org.dta.alexendrie.model.Media;

public interface MediaService {

	public List<Media> getMediaAll();
	public List<Media> getMediaByTitle();
	public Media getMediaById(long id);
}