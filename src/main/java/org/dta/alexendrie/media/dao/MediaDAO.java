package org.dta.alexendrie.media.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.dta.alexendrie.dao.DatabaseHelper;
import org.dta.alexendrie.media.model.Media;
import org.dta.alexendrie.media.model.MediaType;

public class MediaDAO {
	public static Media consulterMedia(int id_media) {
		EntityManager em = DatabaseHelper.createEntityManager();
		
		DatabaseHelper.beginTx(em);
		
		String str_query = "select m.title,m.type,m.author from Media m";

		TypedQuery<Media> query = em.createQuery(str_query, Media.class);

		DatabaseHelper.commitTxAndClose(em);
		
		return query.getSingleResult();
	}

	public static Media creationMedia(String title, String name, MediaType type) {
		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);
		
		Media insertion = new Media(title, name, type, false);

		em.persist(insertion);

		DatabaseHelper.commitTxAndClose(em);
		
		return insertion;
	}

	public static List<Media> rechercheMedias(String title, String name, String type) {
		EntityManager em = DatabaseHelper.createEntityManager();

		String str_query = "select m.title,m.type,m.author,e.adherent.name from Media m join fetch m.emprunts e";

		if ((title != "") || (name != "") || (type != "")) {
			str_query += " where";
			if (title != "")
				str_query += " title = '" + title + "'";
			
			if (name != "")
				str_query += " name = '" + name + "'";
			
			if (type != "")
				str_query += " type = '" + type + "'";
		}

		TypedQuery<Media> query = em.createQuery(str_query, Media.class);

		return query.getResultList();
	}
}