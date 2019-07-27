package com.app.aiolus.repositories;

import java.util.Map;

import com.app.aiolus.entities.Travelling;

public interface TravellingRepository {
	
	
	Travelling addTravelling(Travelling travellingModel);
	Travelling updateTravelling(Travelling travelling);
	Map<String, Object> getAllTravelling(int pageSize, int page);
	Map<String, Object> getAllTravellingByIdUser(long idUser, int pageSize, int page);
	Travelling getSingleTravellById(long id);

}
