package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IOwnerDao;
import com.app.pojos.Owner;
import com.app.service.IOwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	//D.I
	@Autowired
	private IOwnerService ownerController;
	
	public OwnerController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	// requestHandling methods
	@GetMapping
	public ResponseEntity<?> getAllOwners() {
		System.out.println("in mapping");
		return new ResponseEntity<>(ownerController.getAllOwners() , HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<?> saveOwner(@RequestBody Owner o) {
		System.out.println(o.toString());
		return new ResponseEntity<>(ownerController.saveOwner(o) , HttpStatus.CREATED);
	}
	
//	@GetMapping("/{email}/{password}")
//	public ResponseEntity<?> getOwner(@PathVariable String email, @PathVariable String password) {
//		System.out.println("in getOwner mapping");
//		return new ResponseEntity<>(ownerController.getOwner(email, password) , HttpStatus.CREATED);
//	}
	
	@GetMapping("/{ownerId}")
	public ResponseEntity<?> getByOwnerId(@PathVariable int ownerId) {
		return new  ResponseEntity<>(ownerController.getByOwnerId(ownerId), HttpStatus.CREATED);
	}

}
