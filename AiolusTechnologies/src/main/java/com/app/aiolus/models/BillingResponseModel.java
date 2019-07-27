package com.app.aiolus.models;

import java.util.List;

import lombok.Data;

@Data
public class BillingResponseModel {
	
	private long count;
	private long idUser;
	private List<BillingModel> data;
	private String userId;

}
