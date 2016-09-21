package org.dta.alexendrie.loan.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.dta.alexendrie.core.Model;
import org.dta.alexendrie.media.model.Media;
import org.dta.alexendrie.member.model.Member;

@Entity
public class Loan implements Model{

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@NotNull
	private Member member;

	@ManyToOne
	@NotNull
	private Media media;

	@Column
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateEmprunt;
	
	public Loan(){
	}
	
	public Loan(Member member, Media media, Date dateEmprunt){
		this.member = member;
		this.media = media;
		this.dateEmprunt = dateEmprunt;
	}
	
	public Member getMember(){
		return this.member;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}