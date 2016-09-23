package org.dta.alexendrie.controller;

import java.util.List;


import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.model.MediaType;
import org.dta.alexendrie.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaControllerRest {

	@Autowired
	private MediaService mediaService;
	
	@RequestMapping(value="/media_recherche", method= RequestMethod.GET)
	public List<Media> rechercheMedia(@RequestParam("titre") String titre, @RequestParam("auteur") String auteur, @RequestParam("type") MediaType type){
		List<Media> media = null; 
		if(titre.equals("") && auteur.equals("") && type==null){
			media = mediaService.getMediaAll();
		} else {
			media = mediaService.getMediaBy(titre, auteur, type);
		}
		return media;
	}

	@RequestMapping(value = "/resource/media.accession", method = RequestMethod.GET)
	public Media accessionMedia(@RequestParam("id") long id) {
		return mediaService.getMediaById(id);
	}

}
