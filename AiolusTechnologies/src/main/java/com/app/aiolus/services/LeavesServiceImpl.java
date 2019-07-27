package com.app.aiolus.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.app.aiolus.constants.Constant;
import com.app.aiolus.entities.Leaves;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.LeavesModel;
import com.app.aiolus.models.LeavesResponseMedel;
import com.app.aiolus.models.LeavesResponseMedelShowall;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.repositories.LeavesRepository;
import com.app.aiolus.repositories.UserRepository;

@Service
public class LeavesServiceImpl implements LeavesService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LeavesRepository leaveRepository;

	@Autowired
	private Converter<Leaves, LeavesModel> leaveEntityToModelConverter;

	@Autowired
	private Converter<LeavesModel, Leaves> leavesConverter;

	@Override
	public ResponseData addLeave(LeavesModel leaveModel) {

		Leaves leave = (Leaves) leavesConverter.convert(leaveModel);
		User userid = userRepository.getSingleUserIdUser(leaveModel.getIdUser());
		leave.setUser(userid);

		long id = leaveRepository.addLeaves(leave).getIdLeave();
		if (id > Constant.ZERO) {
			return new ResponseData(leave.getIdLeave(), Constant.TRUE, Constant.SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.FAILED_MESSAGE);
		}

	}

	@Override
	public ResponseData updateLeave(LeavesModel leaveModel) {

		Leaves leave = (Leaves) leavesConverter.convert(leaveModel);
		User userid = userRepository.getSingleUserIdUser(leaveModel.getIdUser());
		leave.setUser(userid);

		long id = leaveRepository.updateLeaves(leave).getIdLeave();
		if (id > Constant.ZERO) {
			return new ResponseData(leave.getIdLeave(), Constant.TRUE, Constant.UPDATE_SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.UPDATE_FAILED_MESSAGE);
		}

	}

	@Override
	public LeavesResponseMedelShowall getAllLeaves(int pageSize, int page) {

		LeavesResponseMedelShowall leaveResponseShowall = new LeavesResponseMedelShowall();
		Map<String, Object> map = leaveRepository.getAllLeaves(pageSize, page);
		leaveResponseShowall.setCount((long) map.get(Constant.COUNT));
		List<Leaves> leave = (List<Leaves>) map.get(Constant.DATA);

		List<LeavesModel> leaveList = leave.stream()
				.map(p -> new LeavesModel(p.getIdLeave(), p.getUserName(), p.getReason(), p.getApproveLeave(),
						p.getFromDate(), p.getToDate(), p.getUser().getIdUser(), p.getUser().getUserId()))
				.collect(Collectors.toList());

		leaveResponseShowall.setData(leaveList);

		return leaveResponseShowall;

	}

	@Override
	public LeavesResponseMedel getAllLeaveByIdUser(long idUser, int pageSize, int page) {

		LeavesResponseMedel leaveResponseModel = new LeavesResponseMedel();
		Map<String, Object> map = leaveRepository.getAllLeaveByIdUser(idUser, pageSize, page);

		leaveResponseModel.setCount((long) map.get(Constant.COUNT));
		List<LeavesModel> leaveList = ((Collection<Leaves>) map.get(Constant.DATA)).stream()
				.map(p -> new LeavesModel(p.getIdLeave(), p.getUserName(), p.getReason(), p.getApproveLeave(),
						p.getFromDate(), p.getToDate(), p.getUser().getIdUser(), p.getUser().getUserId()))
				.collect(Collectors.toList());

		leaveResponseModel.setIdUser(idUser);
		leaveResponseModel.setData(leaveList);
		return leaveResponseModel;

	}

	@Override
	public LeavesModel getSingleLeaveById(long idLeave) {

		return leaveEntityToModelConverter.convert(leaveRepository.getSingleLeaveById(idLeave));

	}

}
