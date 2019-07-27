package com.app.aiolus.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aiolus.constants.Constant;
import com.app.aiolus.converters.TravellingConverter;
import com.app.aiolus.entities.Travelling;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.models.TravellingModel;
import com.app.aiolus.models.TravellingResponseModel;
import com.app.aiolus.models.TravellingResponseModelShowAll;
import com.app.aiolus.repositories.TravellingRepository;
import com.app.aiolus.repositories.UserRepository;

@Service
public class TravellingServiceImpl implements TravellingService {

	@Autowired
	private TravellingConverter travellingConverter;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TravellingRepository travellingRepository;

	@Override
	public ResponseData addTravelling(TravellingModel travellingModel) {

		Travelling travelling = travellingConverter.convert(travellingModel);
		User user = userRepository.getSingleUserIdUser(travellingModel.getIdUser());
		travelling.setUser(user);

		long id = travellingRepository.addTravelling(travelling).getId();
		if (id > Constant.ZERO) {
			return new ResponseData(travelling.getId(), Constant.TRUE, Constant.SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.FAILED_MESSAGE);
		}

	}

	@Override
	public ResponseData updateTravelling(TravellingModel travellingModel) {
		Travelling travelling = travellingConverter.convert(travellingModel);
		User user = userRepository.getSingleUserIdUser(travellingModel.getIdUser());
		travelling.setUser(user);
		long id = travellingRepository.updateTravelling(travelling).getId();
		if (id > Constant.ZERO) {
			return new ResponseData(travelling.getId(), Constant.TRUE, Constant.UPDATE_SUCCESSFULL_ADDED);
		} else {
			return new ResponseData(Constant.ZERO, Constant.FALSE, Constant.UPDATE_FAILED_MESSAGE);
		}

	}

	@Override
	public TravellingResponseModelShowAll getAllTravelling(int pageSize, int page) {

		TravellingResponseModelShowAll travellingResponseModel = new TravellingResponseModelShowAll();
		Map<String, Object> map = travellingRepository.getAllTravelling(pageSize, page);
		travellingResponseModel.setCount((long) map.get(Constant.COUNT));
		List<Travelling> travell = (List<Travelling>) map.get(Constant.DATA);
		List<TravellingModel> travellList = travell.stream()
				.map(t -> new TravellingModel(t.getId(), t.getTravTo(), t.getTravFrom(), t.getDateTime(),
						t.getDescription(), t.getUser().getIdUser(), t.getUser().getUserId()))
				.collect(Collectors.toList());

		/*
		 * new ArrayList<>(); travell.forEach(action -> { TravellingModel
		 * travellingModel = new TravellingModel();
		 * travellingModel.setId(action.getId());
		 * travellingModel.setDescription(action.getDescription());
		 * travellingModel.setDateTime(action.getDateTime());
		 * travellingModel.setTravFrom(action.getTravFrom());
		 * travellingModel.setTravTo(action.getTravTo());
		 * travellingModel.setIdUser(action.getUser().getIdUser());
		 * travellingModel.setUserId(action.getUser().getUserId());
		 * 
		 * travellList.add(travellingModel); });
		 */

		travellingResponseModel.setData(travellList);

		return travellingResponseModel;

	}

	@Override
	public TravellingResponseModel getAllTravellingByIdUser(long idUser, int pageSize, int page) {

		TravellingResponseModel travellingResponseModel = new TravellingResponseModel();

		Map<String, Object> value = travellingRepository.getAllTravellingByIdUser(idUser, pageSize, page);

		travellingResponseModel.setCount((long) value.get(Constant.COUNT));

		List<Travelling> trav = (List<Travelling>) value.get(Constant.DATA);
		List<TravellingModel> tavList = trav.stream()
				.map(t -> new TravellingModel(t.getId(), t.getTravTo(), t.getTravFrom(), t.getDateTime(),
						t.getDescription(), t.getUser().getIdUser(), t.getUser().getUserId()))
				.collect(Collectors.toList());

		/*
		 * new ArrayList<>(); trav.forEach(action -> { TravellingModel travellingModel =
		 * new TravellingModel(); travellingModel.setId(action.getId());
		 * travellingModel.setDescription(action.getDescription());
		 * travellingModel.setDateTime(action.getDateTime());
		 * travellingModel.setTravFrom(action.getTravFrom());
		 * travellingModel.setTravTo(action.getTravTo());
		 * travellingModel.setUserId(action.getUser().getUserId());
		 * travellingModel.setIdUser(action.getUser().getIdUser());
		 * tavList.add(travellingModel); });
		 */

		travellingResponseModel.setIdUser(idUser);
		travellingResponseModel.setData(tavList);

		return travellingResponseModel;

	}

	@Override
	public Travelling getSingleTravellById(long id) {

		return travellingRepository.getSingleTravellById(id);

	}
}
