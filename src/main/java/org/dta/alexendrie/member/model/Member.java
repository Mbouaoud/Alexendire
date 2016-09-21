package org.dta.alexendrie.member.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.dta.alexendrie.core.Model;
import org.dta.alexendrie.subscription.model.Subscription;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="member")
public class Member implements Model{
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String lastname;
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	private String mail;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column
	private String address;
	
	@OneToOne
	private Subscription subscription;
	
	public Member(String lastname, String firstname, String mail, Date birthday, String address, Subscription subscription) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.birthday = birthday;
		this.address = address;
		this.subscription = subscription;
	}
	
	public Member(String lastname, String firstname, String mail, Date birthday, String address) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.mail = mail;
		this.birthday = birthday;
		this.address = address;
	}
	
	public Member() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}