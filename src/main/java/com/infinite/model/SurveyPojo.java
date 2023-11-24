package com.infinite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Represents a table in a database
@Table(name = "survey") //Table generation
public class SurveyPojo {

	@Id //Primary key for the entity
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "profession")
	private String profession;
	@Column(name = " interest")
	private String interest;
	@Column(name = " domain")
	private String domain;

	public SurveyPojo(Long id, String username, String email, String profession, String interest, String domain) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.profession = profession;
		this.interest = interest;
		this.domain = domain;
	}

	public SurveyPojo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
