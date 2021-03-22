package com.app.service;

import java.util.List;

import com.app.pojos.Buyer;
import com.app.pojos.LandProperty;
import com.app.pojos.OwnershipType;
import com.app.pojos.PropertyType;

public interface ILandPropertyService {
	
	// add new landProperty
	LandProperty saveNewProperty(LandProperty l);
	
	
	//fetch property by ownerId
	List<LandProperty> fetchPropertyByOId(int ownerId);
	
	//fetch property by cityName
	List<LandProperty> fetchPropertyByCity(String city);
	
	
	//fetch prop by id
	LandProperty fetchById(int propId);
	
	//delete prop by id and owner Id
	LandProperty deletePropertyById(int ownerId, int propId);
	
	//update prop by id
	LandProperty updateProperty(int propId , LandProperty l);
	
	// fetch favBuyers of prop
	List<Buyer> fetchAllFavBuyers(int propId);
	

	List<LandProperty> fetchPropByType(PropertyType propType);
	
	List<LandProperty> fetchPropByOwnerType(OwnershipType ownerType);

	//fetch prop by priceRange
	List<LandProperty> fetchPropertyByPriceBetween(double minPrice, double maxPrice);
	
	//fetch prop by dimension
	List<LandProperty> fetchPropertyByDimension(double length, double breadth);
	
	List<LandProperty> fetchAllProps();
	

}
