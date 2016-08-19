package org.dta.alexendrie.media.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

@Entity
public class Media {

	protected static EntityManagerFactory emf;

	protected static EntityManager em;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	@NotNull
	private String title;

	@Column
	@NotNull
	private String author;

	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private MediaType type;

	@Column
	private boolean status;

	/*@ManyToOne(mappedBy="media")
	private List<Loan> loans;*/

	public Media() {

	}

	public Media(String title, String author, MediaType type, Boolean status) {
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

	public MediaType getType() {
		return this.type;
	}

	public boolean getStatus() {
		return this.status;
	}
}