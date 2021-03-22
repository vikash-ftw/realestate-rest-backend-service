package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.OwnershipType;
import com.app.pojos.PropertyType;
import com.app.service.ILandPropertyService;

@RestController
@RequestMapping("/LandProperty")
@CrossOrigin
public class LandPropertyController {
	
	//D.I
	@Autowired
	private ILandPropertyService propertyService;
	
	public LandPropertyController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	
	@GetMapping("/favBuyers/{propId}")
	public ResponseEntity<?> fetchAllFavBuyers(@PathVariable int propId)
	{
		return new ResponseEntity<>(propertyService.fetchAllFavBuyers(propId), HttpStatus.OK);
	}
	
	@GetMapping("{propId}")
	public ResponseEntity<?> fetchByPropId(@PathVariable int propId){
		try {
			return new ResponseEntity<>(propertyService.fetchById(propId), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	

	@GetMapping("/propType/{propType}")
	public ResponseEntity<?> searchByType(@PathVariable String propType){
		return new ResponseEntity<>(propertyService.fetchPropByType(PropertyType.valueOf(propType.toUpperCase())), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("ownerType/{ownerType}")
	public ResponseEntity<?> searchByOwnerType(@PathVariable String ownerType){
		return new ResponseEntity<>(propertyService.fetchPropByOwnerType(OwnershipType.valueOf(ownerType.toUpperCase())),HttpStatus.ACCEPTED);
	}
	//price range
	@GetMapping("/priceBudget/{minPrice}/{maxPrice}")
	public ResponseEntity<?> fetchByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice)
	{
		return new ResponseEntity<>(propertyService.fetchPropertyByPriceBetween(minPrice, maxPrice), HttpStatus.OK);
	}
	
	//dimension l x b range
	@GetMapping("/dimension/{length}/{breadth}")
	public ResponseEntity<?> fetchByDimension(@PathVariable double length, @PathVariable double breadth)
	{
		return new ResponseEntity<>(propertyService.fetchPropertyByDimension(length, breadth), HttpStatus.OK);
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<?> fetchByCity(@PathVariable String city){
		return new ResponseEntity<>(propertyService.fetchPropertyByCity(city), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> fetchAllProps(){
		return new ResponseEntity<>(propertyService.fetchAllProps(),HttpStatus.OK);
	}
}
