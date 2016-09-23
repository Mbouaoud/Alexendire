package org.dta.alexendrie.model;

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

@Entity
public class Media implements Model{

	@Id
	@GeneratedValue
	private long id;

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

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setType(MediaType type) {
		this.type = type;
	}

	public void setCurrentLoan(Loan currentLoan) {
		this.currentLoan = currentLoan;
	}
}