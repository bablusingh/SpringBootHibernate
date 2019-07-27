package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.Travelling;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.TravellingModel;

@Component("travellinEntityToModelConverter")
public class TravellinEntityToModelConverter implements Converter<Travelling, TravellingModel> {

	@Override
	public TravellingModel convert(Travelling travelling) {
		// TODO Auto-generated method stub
		User user = travelling.getUser();
		TravellingModel travellingModel = new TravellingModel();
		travellingModel.setDateTime(travelling.getDateTime());
		travellingModel.setDescription(travelling.getDescription());
		travellingModel.setTravFrom(travelling.getTravFrom());
		travellingModel.setTravTo(travelling.getTravTo());
		travellingModel.setId(travelling.getId());
		travellingModel.setUserId(user.getUserId());
		travellingModel.setIdUser(user.getIdUser());

		return travellingModel;
	}

}
