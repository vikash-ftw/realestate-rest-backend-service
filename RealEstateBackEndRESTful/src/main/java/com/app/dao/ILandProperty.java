package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.LandProperty;
import com.app.pojos.OwnershipType;
import com.app.pojos.PropertyType;

public interface ILandProperty extends JpaRepository<LandProperty, Integer> {
	
	List<LandProperty> findByPropertyOwner(int ownerId);
	

	
	List<LandProperty> findByPropertyType(PropertyType propType);

//	List<LandProperty> findByPropertyCity(String city);
	
//	List<LandProperty> findByPropertyCityLike(String city);
	
	List<LandProperty> findByPropertyCityContaining(String city);
	
	List<LandProperty> findByPropertyPriceBetween(double minPrice, double maxPrice);

	List<LandProperty> findByOwnershipType(OwnershipType ownerType);
}
