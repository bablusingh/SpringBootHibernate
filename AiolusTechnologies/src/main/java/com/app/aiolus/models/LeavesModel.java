package com.app.aiolus.models;

import java.util.Date;

import lombok.Data;

@Data
public class LeavesModel {
	
	public LeavesModel(){}
	
	public LeavesModel(long idleave,String userName,
			String reason,String approvLeave,Date fromDate
			,Date toDate,long idUser,String userId) {
		
		
		this.idLeave=idleave;
		this.userName=userName;
		this.reason=reason;
		this.approveLeave=approvLeave;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.idUser=idUser;
		this.userId=userId;
		
	}

	private long idLeave;
	private String userName;
	private String reason;
	private String approveLeave;
	private Date fromDate;
	private Date toDate;
	private long idUser;
	private String userId;

	@Override
	public String toString() {
		return "LeaveModel [idLeave=" + idLeave + ", userName=" + userName + ", reason=" + reason + ", approveLeave="
				+ approveLeave + ", fromDate=" + fromDate + ", toDate=" + toDate + ", idUser=" + idUser + ", userId="
				+ userId + "]";
	}

}
