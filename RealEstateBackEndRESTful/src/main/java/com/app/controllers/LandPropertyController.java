package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ILandProperty;
import com.app.pojos.LandProperty;
import com.app.service.ILandPropertyService;

@RestController
@RequestMapping("/LandProperty")
public class LandPropertyController {
	
	//D.I
	@Autowired
	private ILandPropertyService propertyService;
	
	public LandPropertyController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	@GetMapping("/city/{cityName}")
	public ResponseEntity<?> LandPropertyByCity(@PathVariable String cityName) {
		return new ResponseEntity<>(propertyService.fetchPropertyByCity(cityName),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{propId}")
	public ResponseEntity<?> deletePropertyById(@PathVariable int propId){
		try {
			return new ResponseEntity<>(propertyService.deletePropertyById(propId), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
