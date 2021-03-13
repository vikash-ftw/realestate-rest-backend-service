package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.LandProperty;
import com.app.pojos.OwnershipType;
import com.app.pojos.PropertyType;

public interface ILandProperty extends JpaRepository<LandProperty, Integer> {
	
	List<LandProperty> findByPropertyOwner(int ownerId);
	
	
	List<LandProperty> findByPropertyType(PropertyType propType);

	List<LandProperty> findByOwnershipType(OwnershipType ownerType);
}
