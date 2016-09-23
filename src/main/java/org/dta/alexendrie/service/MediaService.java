package org.dta.alexendrie.service;

import java.util.List;

import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.model.MediaType;

public interface MediaService {

	public List<Media> getMediaAll();
	public List<Media> getMediaBy(String titre, String auteur, MediaType type);
}
