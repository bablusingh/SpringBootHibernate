package com.app.aiolus.models;

import lombok.Data;

@Data
public class UserModel {

	private long idUser;
	private String userId;
	private String userPassword;
	private String userType;
	private String userName;

	@Override
	public String toString() {
		return "UserModel [idUser=" + idUser + ", userId=" + userId + ", userPassword=" + userPassword + ", userType="
				+ userType + ", userName=" + userName + "]";
	}

}
