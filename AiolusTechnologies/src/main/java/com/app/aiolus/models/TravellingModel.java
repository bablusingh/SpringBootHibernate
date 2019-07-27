package com.app.aiolus.models;

import java.util.Date;

import lombok.Data;

@Data
public class TravellingModel {

	public TravellingModel() {
	}

	public TravellingModel(long id, String travTo, String travFrom, Date dateTime, String description, long idUser,
			String userId) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.travTo = travTo;
		this.travFrom = travFrom;
		this.dateTime = dateTime;
		this.description = description;
		this.userId = userId;
		this.idUser = idUser;

	}

	private long id;
	private String travFrom;
	private String travTo;
	private Date dateTime;
	private String description;
	private String userId;
	private long idUser;

	@Override
	public String toString() {
		return "TravellingModel [id=" + id + ", travFrom=" + travFrom + ", travTo=" + travTo + ", dateTime=" + dateTime
				+ ", description=" + description + ", userId=" + userId + ", idUser=" + idUser + "]";
	}

}
