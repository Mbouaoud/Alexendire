package org.dta.alexendrie.media.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.dta.alexendrie.core.Model;
import org.dta.alexendrie.loan.model.Loan;

@Entity
public class Media implements Model{

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

	@OneToOne
	private Loan currentLoan;

	@OneToMany(mappedBy="media")
	private List<Loan> loans;

	public Media() {

	}

	public Media(String title, String author, MediaType type) {
		this.title = title;
		this.author = author;
		this.type = type;
		this.currentLoan = null;
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

	public Loan getCurrentLoan() {
		return this.currentLoan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}