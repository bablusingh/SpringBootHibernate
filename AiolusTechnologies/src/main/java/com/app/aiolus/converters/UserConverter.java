package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;
import com.app.aiolus.models.UserDetailModel;

@Component
public class UserConverter implements Converter<UserDetailModel, UserDetail> {

	@Override
	public UserDetail convert(UserDetailModel userDetail) {
		// TODO Auto-generated method stub

		UserDetail userDetails = new UserDetail();
		userDetails.setId(userDetail.getId());
		userDetails.setUserName(userDetail.getUserName());
		userDetails.setUserEmail(userDetail.getUserEmail());
		userDetails.setUserDesignation(userDetail.getUserDesignation());
		userDetails.setUserAddress(userDetail.getUserAddress());
		userDetails.setUserDob(userDetail.getUserDob());
		userDetails.setUserDoj(userDetail.getUserDoj());
		userDetails.setUserGender(userDetail.getUserGender());
		userDetails.setUserMobile(userDetail.getUserMobile());
		userDetails.setUserSalary(userDetail.getUserSalary());
		userDetails.setUserStatus(userDetail.getUserStatus());

		User users = new User();
		users.setIdUser(users.getIdUser());
		users.setUserId(userDetail.getUserId());
		users.setUserPassword(userDetail.getUserPassword());
		users.setUserType(userDetail.getUserType());
		users.setUserName(userDetail.getUserName());

		userDetails.setUser(users);

		return userDetails;
	}

	public UserDetail convertDoLogin(UserDetailModel userDetail) {

		UserDetail userDetails = new UserDetail();

		userDetails.setId(userDetail.getId());
		userDetails.setUserName(userDetail.getUserName());
		userDetails.setUserEmail(userDetail.getUserEmail());
		userDetails.setUserDesignation(userDetail.getUserDesignation());
		userDetails.setUserAddress(userDetail.getUserAddress());
		userDetails.setUserDob(userDetail.getUserDob());
		userDetails.setUserDoj(userDetail.getUserDoj());
		userDetails.setUserGender(userDetail.getUserGender());
		userDetails.setUserMobile(userDetail.getUserMobile());
		userDetails.setUserSalary(userDetail.getUserSalary());
		userDetails.setUserStatus(userDetail.getUserStatus());

		User users = new User();
		users.setUserId(userDetail.getUserId());
		users.setUserPassword(userDetail.getUserPassword());
		users.setUserType(userDetail.getUserType());
		users.setUserName(userDetail.getUserName());

		userDetails.setUser(users);

		return userDetails;

	}

}
