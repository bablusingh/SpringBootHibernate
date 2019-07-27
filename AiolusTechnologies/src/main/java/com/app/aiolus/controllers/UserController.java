package com.app.aiolus.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.aiolus.entities.User;
import com.app.aiolus.entities.UserDetail;
import com.app.aiolus.models.LoginModel;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.models.UserDetailModel;
import com.app.aiolus.models.UserDetailResponseModel;
import com.app.aiolus.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")
@Api(tags = "The controller provides api for the user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userServiceImpl;

	@PostMapping(value = "/saveusers")
	@ApiOperation(value = "The api is used to save user", response = ResponseData.class)
	public ResponseData saveUser(@RequestBody UserDetailModel userDetailModel) {

		return userServiceImpl.addUser(userDetailModel);

	}

	@PutMapping(value = "/updateuser/{id}")
	@ApiOperation(value = "The api is used to update user", response = ResponseData.class)
	public ResponseData updatUser(@RequestBody UserDetailModel userDetail, @PathVariable long id) {

		return userServiceImpl.updateUser(userDetail);

	}

	@GetMapping(value = "/getalluser/{pageSize}/{page}")
	@ApiOperation(value = "The api is display all users")
	public UserDetailResponseModel getAllUser(@PathVariable int pageSize, @PathVariable int page) {
		return userServiceImpl.getAllUser(pageSize, page);

	}

	@GetMapping(value = "/showsingleuserbyid")
	@ApiOperation(value = "The api is display single user on the basis of id")
	public UserDetail getSingleUserById(@RequestParam("id") long id) {

		return userServiceImpl.getSingleUserById(id);

	}

	@PostMapping(value = "/dologin")
	@ApiOperation(value = "The api is used to user login")
	public User doLogin(@Valid @RequestBody LoginModel login) {

		return userServiceImpl.doLogin(login.getUserId(), login.getUserPassword());

	}

	@GetMapping(value = "/getsingleuserbyiduser")
	@ApiOperation(value = "The api is display single user on the basis of iduser")
	public User getSingleUserIdUser(@RequestParam("idUser") long idUser) {

		return userServiceImpl.getSingleUserIdUser(idUser);

	}

}
