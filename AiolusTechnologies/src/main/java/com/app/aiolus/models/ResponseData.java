package com.app.aiolus.models;

import lombok.Data;

@Data
public class ResponseData {
	
	 private long generatedId;
	 private boolean status;
	 private String message;
	 
	 public ResponseData() {}
	 
	 public ResponseData(long generatdId,boolean status,String message) {
		 
		 this.generatedId=generatdId;
		 this.status=status;
		 this.message=message;
		 }
	 

}
