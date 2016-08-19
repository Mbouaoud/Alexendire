package org.dta.alexendrie.subscription.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="subscription")
public class Subscription {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column
	private float amount;
}