package com.app.aiolus.services;

import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.models.UserDetailModel;
import com.app.aiolus.models.UserDetailResponseModel;

public interface UserService {

	
	ResponseData addUser(UserDetailModel userDetail);
	ResponseData updateUser(UserDetailModel userDetail);
	
	User doLogin(String userId, String userPassword);
	User getSingleUserIdUser(long idUser);
	UserDetail getSingleUserById(long id);
	
	UserDetailResponseModel getAllUser(int pageSize,int page);
}
