package com.app.aiolus.models;

import java.util.List;

import lombok.Data;

@Data
public class UserDetailResponseModel {

	private long count;
	private List<UserDetailModel> data;
	private long id;
}
