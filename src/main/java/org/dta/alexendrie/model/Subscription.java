package org.dta.alexendrie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.dta.alexendrie.core.Model;

@Entity
@Table(name="subscription")
public class Subscription implements Model{
	
	@Id
	@GeneratedValue
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column
	private float amount;

	public Subscription(Date paymentDate, float amount) {
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	public Subscription() {
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}