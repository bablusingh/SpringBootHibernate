package com.app.aiolus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.aiolus.entities.Travelling;
import com.app.aiolus.entities.User;
import com.app.aiolus.models.TravellingModel;

@Component
public class TravellingConverter implements Converter<TravellingModel, Travelling> {

	@Override
	public Travelling convert(TravellingModel travellingModel) {
		// TODO Auto-generated method stub
		
		Travelling travelling=new Travelling();
		travelling.setDateTime(travellingModel.getDateTime());
		travelling.setDescription(travellingModel.getDescription());
		travelling.setTravFrom(travellingModel.getTravFrom());
		travelling.setTravTo(travellingModel.getTravTo());
		travelling.setId(travellingModel.getId());
		
		
		
		return travelling;
	}

}
