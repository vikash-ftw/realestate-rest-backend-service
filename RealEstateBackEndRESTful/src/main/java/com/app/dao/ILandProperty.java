package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.LandProperty;

public interface ILandProperty extends JpaRepository<LandProperty, Integer> {
	
	List<LandProperty> findByPropertyOwner(int ownerId);

}
