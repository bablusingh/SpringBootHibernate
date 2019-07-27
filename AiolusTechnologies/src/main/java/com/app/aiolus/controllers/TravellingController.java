package com.app.aiolus.controllers;

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

import com.app.aiolus.entities.Travelling;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.models.TravellingModel;
import com.app.aiolus.models.TravellingResponseModel;
import com.app.aiolus.models.TravellingResponseModelShowAll;
import com.app.aiolus.services.TravellingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/travelling")
@Api(tags = "The controller provides api for the travelling")
public class TravellingController {

	@Autowired
	private TravellingService travellServiceimpl;

	@PostMapping(value = "/savetravelling")
	@ApiOperation(value = "The api is used to add travelling",response = ResponseData.class)
	public ResponseData addTravelling(@RequestBody TravellingModel travellingModel) {

		return travellServiceimpl.addTravelling(travellingModel);

	}

	@PutMapping(value = "/updatetravelling")
	@ApiOperation(value = "The api is used to update travelling",response = ResponseData.class)
	public ResponseData updateTravelling(@RequestBody TravellingModel travellingModel) {

		return travellServiceimpl.updateTravelling(travellingModel);

	}

	@GetMapping(value = "/getalltravelling/{pageSize}/{page}")
	@ApiOperation(value = "The api is display all travelling")
	public TravellingResponseModelShowAll getAllTravelling(@PathVariable int pageSize, @PathVariable int page) {

		return travellServiceimpl.getAllTravelling(pageSize, page);

	}

	@GetMapping(value = "/getalltravellbyiduser/{idUser}/{pageSize}/{page}")
	@ApiOperation(value = "The api is display all travelling on the basis of iduser")
	public TravellingResponseModel getAllTravellingByIdUser(@PathVariable long idUser, @PathVariable int pageSize,
			@PathVariable int page) {

		return travellServiceimpl.getAllTravellingByIdUser(idUser, pageSize, page);

	}

	@GetMapping(value = "/getsingletravellingbyid")
	@ApiOperation(value = "The api is display single  travelling on the basis of id")
	public Travelling getSingleTravellById(@RequestParam("id") long id) {
		return travellServiceimpl.getSingleTravellById(id);

	}

}
