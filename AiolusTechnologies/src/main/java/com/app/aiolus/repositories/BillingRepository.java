package com.app.aiolus.repositories;

import java.util.Map;

import com.app.aiolus.entities.Billing;

public interface BillingRepository {
	
	Billing addBilling(Billing billing);
	Billing updateBilling(Billing billing);
	Map<String, Object> getBillingByIdUser(long idUser, int pageSize, int page);
	Map<String, Object> getAllBilling(int pageSize, int page);
	Billing getSingleBillingById(long id);

}
