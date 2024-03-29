package com.app.aiolus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;
	@Column(unique = true)
	private String userId;
	private String userPassword;
	private String userType;
	private String userName;

}
