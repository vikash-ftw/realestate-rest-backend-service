package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.LandProperty;
import com.app.pojos.Owner;
import com.app.service.ILandPropertyService;
import com.app.service.IOwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	//D.I
	@Autowired
	private IOwnerService ownerService;
	
	@Autowired
	private ILandPropertyService landService;
	
	public OwnerController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	// requestHandling methods
	@GetMapping
	public ResponseEntity<?> getAllOwners() {
		System.out.println("in mapping");
		return new ResponseEntity<>(ownerService.getAllOwners() , HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<?> saveOwner(@RequestBody Owner o) {
		System.out.println(o.toString());
		return new ResponseEntity<>(ownerService.saveOwner(o) , HttpStatus.CREATED);
	}
	
//	@GetMapping("/{email}/{password}")
//	public ResponseEntity<?> getOwner(@PathVariable String email, @PathVariable String password) {
//		System.out.println("in getOwner mapping");
//		return new ResponseEntity<>(ownerController.getOwner(email, password) , HttpStatus.CREATED);
//	}
	
	@GetMapping("/{ownerId}")
	public ResponseEntity<?> getByOwnerId(@PathVariable int ownerId) {
		return new  ResponseEntity<>(ownerService.getByOwnerId(ownerId), HttpStatus.CREATED);
	}
	
	@PostMapping("/newProperty/{ownerId}")
	public ResponseEntity<?> saveNewProperty(@RequestBody LandProperty p, 
			@PathVariable int ownerId)
	{
		Owner actualOwner = ownerService.getByOwnerId(ownerId);
		actualOwner.addNewProperty(p);
		
		return new ResponseEntity<>(landService.saveNewProperty(p), HttpStatus.OK);
	}
	
	@GetMapping("/myProperty/{ownerId}")
	public ResponseEntity<?> getAllProperty(@PathVariable int ownerId)
	{
		return new ResponseEntity<>(ownerService.getByOwnerId(ownerId).getLandProperties(), 
				HttpStatus.OK);
	}
}
