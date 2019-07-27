package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.Leaves;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.LeavesModel;

@Component("leaveEntityToModelConverter")
public class LeaveEntityToModelConverter implements Converter<Leaves, LeavesModel>{

	@Override
	public LeavesModel convert(Leaves leaves) {
		
		User user=leaves.getUser();
		LeavesModel leavesModel=new LeavesModel();
		leavesModel.setUserName(leaves.getUserName());
		leavesModel.setApproveLeave(leaves.getApproveLeave());
		leavesModel.setFromDate(leaves.getFromDate());
		leavesModel.setReason(leaves.getReason());
		leavesModel.setIdLeave(leaves.getIdLeave());
		leavesModel.setIdUser(user.getIdUser());
		leavesModel.setUserId(user.getUserId());
		return leavesModel;
	}

}
