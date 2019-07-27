package com.app.aiolus.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.aiolus.models.BillingModel;
import com.app.aiolus.models.BillingResponseModel;
import com.app.aiolus.models.BillingResponseModelShowAll;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.services.BillingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/billing")
@Api(tags = "The controller provides api for the billing")
public class BillingController {

	@Autowired
	private BillingService billingServiceImpl;

	@PostMapping(value = "/addbilling")
	@ApiOperation(value = "The api is used to add billing", response = ResponseData.class)
	public ResponseData addBill(@Valid @RequestBody BillingModel billingModel) {

		return billingServiceImpl.addBilling(billingModel);

	}

	@PutMapping(value = "/updatebilling")
	@ApiOperation(value = "The api is used to update billing", response = ResponseData.class)
	public ResponseData updateBilling(@RequestBody BillingModel billing) {

		return billingServiceImpl.updateBilling(billing);

	}

	@GetMapping(value = "/getbillingbyiduser/{idUser}/{pageSize}/{page}")
	@ApiOperation(value = "The api is display all billing on the basis of iduser")
	public BillingResponseModel getBillingByIdUser(@PathVariable long idUser, @PathVariable int pageSize,
			@PathVariable int page) {
		return billingServiceImpl.getBillingByIdUser(idUser, pageSize, page);

	}

	@GetMapping(value = "/getallbilling/{pageSize}/{page}")
	@ApiOperation(value = "The api is display all billing")
	public BillingResponseModelShowAll getAllBilling(@PathVariable int pageSize, @PathVariable int page) {
		return billingServiceImpl.getAllBilling(pageSize, page);

	}

	@GetMapping(value = "/getsinglebillingbyid")
	@ApiOperation(value = "The api is display single  billing on the basis of id")
	public BillingModel getSingleBillingById(@RequestParam("id") long id) {
		return billingServiceImpl.getSingleBillingById(id);
	}

}
