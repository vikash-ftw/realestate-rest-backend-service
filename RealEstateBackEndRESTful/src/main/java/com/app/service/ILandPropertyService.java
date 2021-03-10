package com.app.service;

import java.util.List;

import com.app.pojos.LandProperty;

public interface ILandPropertyService {
	
	// add new landProperty
	LandProperty saveNewProperty(LandProperty l);
	
	//fetch property by ownerId
	List<LandProperty> fetchPropertyByOId(int ownerId);
	
	//fetch by cityName
	List<LandProperty> fetchPropertyByCity(String city);
}
