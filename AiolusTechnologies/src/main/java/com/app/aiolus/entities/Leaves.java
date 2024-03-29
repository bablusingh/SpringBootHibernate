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
public class Leaves {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLeave;
	private String userName;
	private String reason;
	private String approveLeave;
	private Date fromDate;
	private Date toDate;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "idUser")
	private User user;

}
