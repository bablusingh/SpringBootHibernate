package com.app.aiolus.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Travelling {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String travFrom;
	private String travTo;
	private Date dateTime;
	private String description;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "idUser")
	private User user;



}
