package com.app.aiolus.services;

import com.app.aiolus.entities.Travelling;
import com.app.aiolus.models.ResponseData;
import com.app.aiolus.models.TravellingModel;
import com.app.aiolus.models.TravellingResponseModel;
import com.app.aiolus.models.TravellingResponseModelShowAll;

public interface TravellingService {
	
	
	ResponseData addTravelling(TravellingModel travellingModel);
	ResponseData updateTravelling(TravellingModel travellingModel);
	TravellingResponseModelShowAll getAllTravelling(int pageSize, int page);
	TravellingResponseModel getAllTravellingByIdUser(long idUser, int pageSize, int page);
	Travelling getSingleTravellById(long id);

}
