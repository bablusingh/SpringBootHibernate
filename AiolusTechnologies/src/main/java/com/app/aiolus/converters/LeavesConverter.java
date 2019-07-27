package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.Leaves;
import com.app.aiolus.models.LeavesModel;

@Component("leavesConverter")
public class LeavesConverter implements Converter<LeavesModel, Leaves> {

	@Override
	public Leaves convert(LeavesModel leaveModel) {
		// TODO Auto-generated method stub
		
		Leaves leaves=new Leaves();
		
		leaves.setApproveLeave(leaveModel.getApproveLeave());
		leaves.setFromDate(leaveModel.getFromDate());
		leaves.setToDate(leaveModel.getToDate());
		leaves.setReason(leaveModel.getReason());
		leaves.setIdLeave(leaveModel.getIdLeave());
		leaves.setUserName(leaveModel.getUserName());
		
		return leaves;
	}
	
	
	
	
	

}
