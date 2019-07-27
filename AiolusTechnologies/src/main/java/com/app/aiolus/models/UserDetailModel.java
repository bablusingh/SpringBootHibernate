package com.app.aiolus.models;

import java.util.Date;

import lombok.Data;

@Data
public class UserDetailModel {

	private long id;
	private String userName;
	private String userGender;
	private Date userDob;
	private Date userDoj;
	private String userDesignation;
	private String userEmail;
	private String userSalary;
	private String userStatus;
	private String userMobile;
	private String userAddress;
	private long idUser;
	private String userId;
	private String userPassword;
	private String userType;

	@Override
	public String toString() {
		return "UserDetailModel [id=" + id + ", userName=" + userName + ", userGender=" + userGender + ", userDob="
				+ userDob + ", userDoj=" + userDoj + ", userDesignation=" + userDesignation + ", userEmail=" + userEmail
				+ ", userSalary=" + userSalary + ", userStatus=" + userStatus + ", userMobile=" + userMobile
				+ ", userAddress=" + userAddress + ", idUser=" + idUser + ", userId=" + userId + ", userPassword="
				+ userPassword + ", userType=" + userType + "]";
	}

}
