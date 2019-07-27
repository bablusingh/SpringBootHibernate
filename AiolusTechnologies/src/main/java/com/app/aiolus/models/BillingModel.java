package com.app.aiolus.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BillingModel {

	public BillingModel() {}
	public BillingModel(long id, String itemName, Date dateTime, String amount, String description, String siteId,
			long idUser, String userId) {

		this.id = id;
		this.amount = amount;
		this.dateTime = dateTime;
		this.description = description;
		this.itemName = itemName;
		this.siteId = siteId;
		this.idUser = idUser;
		this.userId = userId;

	}

	private long id;
	@NotNull(message = "itemName can not be null")
	private String itemName;
	@NotNull(message = "Amount can not be null")
	private String amount;
	
	private Date dateTime;
	private String description;
	private String siteId;
	private long idUser;
	private String userId;
	
	@Override
	public String toString() {
		return "BillingModel [id=" + id + ", itemName=" + itemName + ", amount=" + amount + ", dateTime=" + dateTime
				+ ", description=" + description + ", siteId=" + siteId + ", idUser=" + idUser + ", userId=" + userId
				+ "]";
	}

}
