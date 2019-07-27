package com.app.aiolus.services;


import com.app.aiolus.models.BillingModel;
import com.app.aiolus.models.BillingResponseModel;
import com.app.aiolus.models.BillingResponseModelShowAll;
import com.app.aiolus.models.ResponseData;

public interface BillingService {
	
	
	ResponseData addBilling(BillingModel billingModel);
	ResponseData updateBilling(BillingModel billingModel);
	BillingResponseModel getBillingByIdUser(long idUser, int pageSize, int page);
	BillingResponseModelShowAll getAllBilling(int pageSize, int page);
	BillingModel getSingleBillingById(long id);

}
