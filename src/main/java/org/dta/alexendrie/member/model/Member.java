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
import org.dta.alexendrie.subscription.model.Subscription;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="member")
public class Member {
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank
	private String lastname;
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	private String mail;
	
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column
	private String address;
	
	@OneToOne
	private Subscription subscription;
}