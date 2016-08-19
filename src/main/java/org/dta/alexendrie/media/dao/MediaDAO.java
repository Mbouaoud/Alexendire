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

		Media retour = em.find(Media.class, id_media);
		em.close();
		return retour;
	}

	public static Media creationMedia(String title, String name, MediaType type) {

		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		Media insertion = new Media(title, name, type);

		em.persist(insertion);

		DatabaseHelper.commitTxAndClose(em);

		return insertion;
	}

	public static List<Media> rechercheMedias(String title, String name, String type) {

		EntityManager em = DatabaseHelper.createEntityManager();

		String str_query = "select m from Media m left join fetch m.currentLoan cl left join fetch cl.member";

		if (title != "")
			str_query += " and title = '" + title + "'";
		if (name != "")
			str_query += " and name = '" + name + "'";
		if (type != "")
			str_query += " and type = '" + type + "'";

		TypedQuery<Media> query = em.createQuery(str_query, Media.class);

		return query.getResultList();
	}
}
