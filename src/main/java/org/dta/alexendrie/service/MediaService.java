package org.dta.alexendrie.service;

import java.util.List;
import org.dta.alexendrie.model.Media;

public interface MediaService extends GenericService<Media>{

	public List<Media> getMediaAll();
	public List<Media> getMediaByTitle();
}