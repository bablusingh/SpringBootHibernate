package com.app.aiolus.services;

import com.app.aiolus.models.LeavesModel;
import com.app.aiolus.models.LeavesResponseMedel;
import com.app.aiolus.models.LeavesResponseMedelShowall;
import com.app.aiolus.models.ResponseData;


public interface LeavesService {
	
	ResponseData addLeave(LeavesModel leaveModel);
	ResponseData updateLeave(LeavesModel leaveModel);
	LeavesResponseMedelShowall getAllLeaves(int pageSize, int page);
	LeavesResponseMedel getAllLeaveByIdUser(long idUser, int pageSize, int page);
	LeavesModel getSingleLeaveById(long idLeave );
	


}
