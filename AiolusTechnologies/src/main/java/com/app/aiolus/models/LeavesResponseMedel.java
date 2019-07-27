package com.app.aiolus.models;

import java.util.List;

import lombok.Data;
@Data
public class LeavesResponseMedel {

	
	private long count;
	private long idUser;
	private List<LeavesModel> data;
	private String userId;
	
}
