package com.app.aiolus.models;

import java.util.List;

import lombok.Data;

@Data
public class BillingResponseModelShowAll {
	
	private long count;
	private List<BillingModel> data;
	private String userId;


}
