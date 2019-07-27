package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.Billing;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.BillingModel;

@Component("billingEntityToModelConverter")
public class BillingEntityToModelConverter implements Converter<Billing, BillingModel>{

	@Override
	public BillingModel convert(Billing billing) {
		// TODO Auto-generated method stub
		User user=billing.getUser();
		BillingModel billingModel=new BillingModel();
		billingModel.setAmount(billing.getAmount());
		billingModel.setDateTime(billing.getDateTime());
		billingModel.setDescription(billing.getDescription());
		billingModel.setItemName(billing.getItemName());
		billingModel.setSiteId(billing.getSiteId());
		billingModel.setId(billing.getId());
		billingModel.setIdUser(billing.getUser().getIdUser());
		billingModel.setUserId(billing.getUser().getUserId());
		
		
		return billingModel;
	}

	

}
