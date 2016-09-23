package org.dta.alexendrie.repository.impl;

import java.util.List;

import org.dta.alexendrie.core.JpaRepositoryImpl;
import org.dta.alexendrie.model.Media;
import org.dta.alexendrie.model.MediaType;
import org.dta.alexendrie.repository.MediaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MediaRepositoryImpl extends JpaRepositoryImpl<Media> implements MediaRepository{
	
	@Override
	protected Class<Media> getEntityClass() {
		return Media.class;
	}

	@Override
	public List<Media> findMediaBy(String titre, String auteur, MediaType type) {
		String str = "select m from Media m where ";
		boolean et = false;
		if (!(titre.equals(""))){
			str = str + "lower(m.title)='"+titre.toLowerCase()+"'";
			et = true;
		}
		if(!(auteur.equals(""))){
			if (et){
				str = str+" and ";
			}
			str = str + "lower(m.author)='"+auteur.toLowerCase()+"'";
			et = true;
		}
		if(type!=null){
			if (et){
				str = str+" and ";
			}
			str = str + "m.type='"+type+"'";
		}
		return findBy(str);
	}
}