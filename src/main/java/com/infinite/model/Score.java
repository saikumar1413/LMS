package com.infinite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Score {

	@Id //Primary key for the entity
	@GeneratedValue 
	private Long id;  //primary key for the entity
	private String username;
	private String fullname;
	private int scores;

	public Score() {
		super(); //calls the constructor for the parent class
	}

	public Score(Long id, String username, String fullname, int scores) {
		super(); //calls the constructor for the parent class
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.scores = scores;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

}
