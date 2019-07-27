package com.app.aiolus.models;

import java.util.List;

import lombok.Data;

@Data
public class TravellingResponseModelShowAll {
	
	private long count;
	private List<TravellingModel> data;
	private String userId;


}
