package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.Billing;
import com.app.aiolus.models.BillingModel;

@Component("billingConverter")
public class BillingConverter implements Converter<BillingModel, Billing> {

	@Override
	public Billing convert(BillingModel billing) {
		// TODO Auto-generated method stub
		Billing bill = new Billing();

		bill.setAmount(billing.getAmount());
		bill.setDateTime(billing.getDateTime());
		bill.setDescription(billing.getDescription());
		bill.setItemName(billing.getItemName());
		bill.setId(billing.getId());
		bill.setSiteId(billing.getSiteId());

		return bill;
	}

}
