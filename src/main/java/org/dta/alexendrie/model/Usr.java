package org.dta.alexendrie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.dta.alexendrie.core.Model;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usr implements Model {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	@NotBlank
	private String login;

	@Column
	@NotBlank
	private String password;

	public Usr(String login, String password) {
		this.login = login;
		this.password = password;

	}

	public Usr() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}