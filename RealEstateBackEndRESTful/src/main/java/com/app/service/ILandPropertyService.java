package com.app.service;

import java.util.List;

import com.app.pojos.LandProperty;

public interface ILandPropertyService {
	
	// add new landProperty
	LandProperty saveNewProperty(LandProperty l);
	
	//fetch pr
	
	//fetch property by ownerId
	List<LandProperty> fetchPropertyByOId(int ownerId);
	
	//fetch by cityName
	List<LandProperty> fetchPropertyByCity(String city);
	
	//fetch prop by id
	LandProperty fetchById(int propId);
	
	//delete prop by id
	LandProperty deletePropertyById(int propId);
}
