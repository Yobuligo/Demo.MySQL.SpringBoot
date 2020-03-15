package com.vpsd.demomysql.person;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.vpsd.demomysql.token.Token;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)		
	private PersonGender gender;
	@Column(updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp	
	private Timestamp changedAt;

	@OneToOne
	private Token token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public PersonGender getGender() {
		return gender;
	}

	public void setGender(PersonGender gender) {
		this.gender = gender;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Timestamp changedAt) {
		this.changedAt = changedAt;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

}
