package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.LandProperty;

public interface ILandProperty extends JpaRepository<LandProperty, Integer> {
	
	

}
