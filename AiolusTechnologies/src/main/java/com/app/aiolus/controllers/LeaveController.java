package com.app.aiolus.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.app.aiolus.models.LeavesModel;
import com.app.aiolus.models.LeavesResponseMedel;
import com.app.aiolus.models.LeavesResponseMedelShowall;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.services.LeavesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/leaves")
@Api(tags = "This controller provides api for the leave")
public class LeaveController {

	private static final Logger log = LoggerFactory.getLogger(LeaveController.class);

	@Autowired
	private LeavesService leaveServiceimpl;

	@PostMapping(value = "/saveleave")
	@ApiOperation(value = "The api is use to save  leave")
	public ResponseData addLeave(@Valid @RequestBody LeavesModel leaveModel) {

		return leaveServiceimpl.addLeave(leaveModel);
	}

	@PutMapping(value = "/updateleave")
	@ApiOperation(value = "The api is use to update  leave")
	public ResponseData UpdateLeave(@Valid @RequestBody LeavesModel leaveModel) {

		return leaveServiceimpl.updateLeave(leaveModel);
	}

	@GetMapping(value = "/getallleave/{pageSize}/{page}")
	@ApiOperation(value = "The api is use to display all  leave")
	public LeavesResponseMedelShowall getAllLeaves(@PathVariable int pageSize, @PathVariable int page) {

		return leaveServiceimpl.getAllLeaves(pageSize, page);

	}

	@GetMapping(value = "/getallleavebyiduser/{idUser}/{pageSize}/{page}")
	@ApiOperation(value = "The api is display all leaves on the basis of iduser")
	public LeavesResponseMedel getAllLeaveByIdUser(@PathVariable long idUser, @PathVariable int pageSize,
			@PathVariable int page) {

		return leaveServiceimpl.getAllLeaveByIdUser(idUser, pageSize, page);

	}

	@GetMapping(value = "/getsingleleavebyid")
	@ApiOperation(value = "The api is display single  leave on the basis of id")
	public LeavesModel getSingleLeaveById(@RequestParam("idLeave") long idLeave) {
		return leaveServiceimpl.getSingleLeaveById(idLeave);

	}
}
