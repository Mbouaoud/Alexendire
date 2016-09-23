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
	
	@RequestMapping(value="/resource/media.recherche", method= RequestMethod.GET)
	public List<Media> rechercheMedia(@RequestParam("titre") String titre, @RequestParam("auteur") String auteur, @RequestParam("type") MediaType type){
		List<Media> mediaAll= mediaService.getMediaAll();
		return mediaAll;
	}
	
	@RequestMapping(value = "/media_creation", method = RequestMethod.POST)
	public boolean ajoutMedia(@RequestParam String titre, @RequestParam String auteur, @RequestParam String type){
		Media media = new Media();
		
		media.setId(1);
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
}