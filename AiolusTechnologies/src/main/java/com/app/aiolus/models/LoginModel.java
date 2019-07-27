package com.app.aiolus.models;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginModel {
	
	@NotNull(message="UserId Can not be null")
	private String userId;
	@NotNull(message="password Can not be null")
	private String userPassword;
	
	

}
