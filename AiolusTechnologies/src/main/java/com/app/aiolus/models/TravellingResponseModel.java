package com.app.aiolus.models;

import java.util.List;

import lombok.Data;

@Data
public class TravellingResponseModel {
	
	private long count;
	private long idUser;
	private List<TravellingModel> data;
	private String userId;

}
