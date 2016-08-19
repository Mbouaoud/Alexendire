package org.dta.alexendrie.media.model;

import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.dta.alexendrie.loan.model.Loan;
import org.dta.alexendrie.member.model.Member;

@Entity
public class Media {

	@Id
	@GeneratedValue
	private int id;

	@Column
	@NotNull
	private String title;

	@Column
	@NotNull
	private String author;

	@Column
	@NotNull
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
	
}
