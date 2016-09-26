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
@RequestMapping("/rest/")
public class MediaControllerRest {

	@Autowired
	private MediaService mediaService;
	
	@RequestMapping(value="/media_recherche", method= RequestMethod.GET)
	public List<Media> rechercheMedia(@RequestParam(name="titre", required=false) String titre, @RequestParam(name="auteur", required=false) String auteur, @RequestParam(name="type", required=false) String type){
		
		List<Media> media = null;
		if(titre == null) titre = "";
		if(auteur == null) auteur = "";
		
		if("".equals(titre) && "".equals(auteur) && type==null){
			media = mediaService.getMediaAll();
		} else {
			MediaType t = MediaType.valueOf(type);
			media = mediaService.getMediaBy(titre, auteur, t);
		}
		
		return media;
	}
	
	@RequestMapping(value = "/media_creation", method = RequestMethod.POST)
	public boolean ajoutMedia(@RequestParam String titre, @RequestParam String auteur, @RequestParam String type){
		Media media = new Media();
		
		media.setId(0);
		media.setAuthor(auteur);
		media.setTitle(titre);
		media.setType(MediaType.valueOf(type));

		Media checkM = mediaService.save(media);
		
		if(checkM != null){
			return true;
		}else{
			return false;
		}
	}
	
	@RequestMapping(value = "/media_modification", method = RequestMethod.POST)
	public boolean modificationMedia(@RequestParam long id, @RequestParam String titre, @RequestParam String auteur, @RequestParam String type){
		Media media = mediaService.getById(id);
		
		media.setAuthor(auteur);
		media.setTitle(titre);
		media.setType(MediaType.valueOf(type));
		
		Media checkM = mediaService.save(media);
		
		if(checkM != null){
			return true;
		}else{
			return false;
		}
	}

	@RequestMapping(value = "/media_accession", method = RequestMethod.GET)
	public Media accessionMedia(@RequestParam("id") long id) {
		return mediaService.getMediaById(id);
	}
}