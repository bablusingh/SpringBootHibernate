package com.app.aiolus.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aiolus.constants.Constant;
import com.app.aiolus.converters.UserConverter;
import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.models.UserDetailModel;
import com.app.aiolus.models.UserDetailResponseModel;
import com.app.aiolus.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private UserRepository userRepositoryimpl;

	@Override
	public ResponseData addUser(UserDetailModel userDetail) {

		UserDetail usersdetail = userConverter.convert(userDetail);
		User user = usersdetail.getUser();
		long id = userRepositoryimpl.addUser(usersdetail).getId();

		if (id > Constant.ZERO) {
			return new ResponseData(usersdetail.getId(), Constant.TRUE, Constant.SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.FAILED_MESSAGE);
		}

	}
	@Override
	public ResponseData updateUser(UserDetailModel userDetail) {

		UserDetail usersdetails = userConverter.convert(userDetail);
		User user = userRepositoryimpl.getSingleUserIdUser(userDetail.getIdUser());
		usersdetails.setUser(user);
		
		
		long id = userRepositoryimpl.updateUser(usersdetails).getId();

		if (id > Constant.ZERO) {
			return new ResponseData(userDetail.getId(), Constant.TRUE, Constant.UPDATE_SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.UPDATE_FAILED_MESSAGE);
		}

	}
	@Override
	public UserDetailResponseModel getAllUser(int pageSize,int page) {
		
		UserDetailResponseModel userDetailResponseModel=new UserDetailResponseModel();
		Map<String, Object> map=userRepositoryimpl.getAllUser(pageSize, page);
		userDetailResponseModel.setCount((long) map.get(Constant.COUNT));
		List<UserDetail> userDelail=(List<UserDetail>) map.get(Constant.DATA);
		List<UserDetailModel> userList=new ArrayList<>();
		userDelail.forEach(action->{
			
			UserDetailModel userDetailModel=new UserDetailModel();
			userDetailModel.setId(action.getId());
			userDetailModel.setIdUser(action.getUser().getIdUser());
			userDetailModel.setUserAddress(action.getUserAddress());
			userDetailModel.setUserDesignation(action.getUserDesignation());
			
			
			
			
			userList.add(userDetailModel);
			
			
		});
		userDetailResponseModel.setData(userList);
		
      return userDetailResponseModel;

		

	}
	@Override
	public UserDetail getSingleUserById(long id) {

		return userRepositoryimpl.getSingleUserById(id);

	}
	@Override
	public User doLogin(String userId, String userPassword) {

		return userRepositoryimpl.doLogin(userId, userPassword);

	}

	@Override
	public User getSingleUserIdUser(long idUser) {

		return userRepositoryimpl.getSingleUserIdUser(idUser);

	}

}
