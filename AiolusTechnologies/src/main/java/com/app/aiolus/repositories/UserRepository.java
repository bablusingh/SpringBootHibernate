package com.app.aiolus.repositories;

import java.util.Map;

import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;

public interface UserRepository {

	UserDetail addUser(UserDetail userDetail);

	UserDetail updateUser(UserDetail userDetail);

	UserDetail getSingleUserById(long id);

	User doLogin(String userId, String userPassword);

	User getSingleUserIdUser(long idUser);

	Map<String, Object> getAllUser(int pageSize, int page);

}
