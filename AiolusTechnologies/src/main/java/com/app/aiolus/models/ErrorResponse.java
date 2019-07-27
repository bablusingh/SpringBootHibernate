package com.app.aiolus.models;

import lombok.Data;

@Data
public class ErrorResponse {
	
	
	private String message;
	private String code;
	
	public ErrorResponse(){}
	public ErrorResponse(String message,String code){
		this.message=message;
		this.code=code;
		
	}
	

}
