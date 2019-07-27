package com.app.aiolus.repositories;

import java.util.Map;

import com.app.aiolus.entities.Leaves;

public interface LeavesRepository {

	Leaves addLeaves(Leaves leaves);

	Leaves updateLeaves(Leaves leaves);

	Map<String, Object> getAllLeaves(int pageSize, int page);

	Map<String, Object> getAllLeaveByIdUser(long idUser, int pageSize, int page);

	Leaves getSingleLeaveById(long idLeave);

}
