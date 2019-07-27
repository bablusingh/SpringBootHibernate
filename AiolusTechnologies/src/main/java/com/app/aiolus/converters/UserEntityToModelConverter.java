package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;
import com.app.aiolus.models.UserDetailModel;

@Component("userEntityToModelConverter")
public class UserEntityToModelConverter implements Converter<UserDetail, UserDetailModel> {

	@Override
	public UserDetailModel convert(UserDetail userDetail) {
		// TODO Auto-generated method stub
		User user = userDetail.getUser();
		UserDetailModel userDetailModel = new UserDetailModel();
		userDetailModel.setId(userDetail.getId());
		userDetailModel.setUserName(userDetail.getUserName());
		userDetailModel.setUserEmail(userDetail.getUserEmail());
		userDetailModel.setUserDesignation(userDetail.getUserDesignation());
		userDetailModel.setUserAddress(userDetail.getUserAddress());
		userDetailModel.setUserDob(userDetail.getUserDob());
		userDetailModel.setUserDoj(userDetail.getUserDoj());
		userDetailModel.setUserGender(userDetail.getUserGender());
		userDetailModel.setUserMobile(userDetail.getUserMobile());
		userDetailModel.setUserSalary(userDetail.getUserSalary());
		userDetailModel.setUserStatus(userDetail.getUserStatus());

		userDetailModel.setIdUser(user.getIdUser());
		userDetailModel.setUserId(user.getUserId());
		userDetailModel.setUserPassword(user.getUserPassword());
		userDetailModel.setUserType(user.getUserType());
		userDetailModel.setUserName(user.getUserName());

		return userDetailModel;
	}

}
