package com.infinite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//Represents a table in a database
@Entity
public class AdminPojo {
    //Primary key for the entity
	@Id
	//
	@GeneratedValue
	private Long id; //primary key for the entity
	private String adminname;
	private String adminpassword;

	public AdminPojo(Long id, String adminname, String adminpassword) {
		//calls the constructor for the parent class
		super();
		this.id = id;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}

	public AdminPojo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}
