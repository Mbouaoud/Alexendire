package org.dta.alexendrie.media.model;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

enum Type {
	Livre("Livre"), CD("CD"), DVD("DVD");

	private String value = "";

	private Type(String value) {
		this.value = value;
	}
}

@Entity
public class Media {

	protected static EntityManagerFactory emf;

	protected static EntityManager em;

	@Id
	@GeneratedValue
	private int id = 0;

	@Column
	@NotNull
	private String title;

	@Column
	@NotNull
	private String author;

	@Column
	@NotNull
	private Type type;

	@Column
	private boolean status;
/*
	@ManyToOne(mappedBy="media")
	private List<Emprunt> emprunts;
*/
	Media() {

	}

	Media(String title, String author, Type type, Boolean status) {
		this.title = title;
		this.author = author;
		this.type = type;
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public Type getType() {
		return this.type;
	}

	public boolean getStatus() {
		return this.status;
	}

	public static void main(String args[]) {

		System.out.println("Lancement du programme...");

		emf = Persistence.createEntityManagerFactory("unit");
		em = emf.createEntityManager();

		em.close();
		emf.close();
	}

	public static Media consulterMedia(int id_media) {

		emf = Persistence.createEntityManagerFactory("unit");
		em = emf.createEntityManager();

		String str_query = "select m.title,m.type,m.author from Media m";

		TypedQuery<Media> query = em.createQuery(str_query, Media.class);

		em.close();
		emf.close();
		return query.getSingleResult();
	}

	public static void creationMedia(String title, String name, Type type) {

		emf = Persistence.createEntityManagerFactory("unit");
		em = emf.createEntityManager();

		Media insertion = new Media(title, name, type, false);

		em.persist(insertion);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static List<Media> rechercheMedias(String title, String name, String type) {

		emf = Persistence.createEntityManagerFactory("unit");
		em = emf.createEntityManager();

		String str_query = "select m.title,m.type,m.author,e.adherent.name from Media m join fetch m.emprunts e";

		if ((title != "") || (name != "") || (title != "")) {
			str_query += " where";
			if (title != "")
				str_query += " title = '" + title + "'";
			if (name != "")
				str_query += " name = '" + name + "'";
			if (type != "")
				str_query += " type = '" + type + "'";
		}

		TypedQuery<Media> query = em.createQuery(str_query, Media.class);

		em.close();
		emf.close();
		return query.getResultList();
	}

}
