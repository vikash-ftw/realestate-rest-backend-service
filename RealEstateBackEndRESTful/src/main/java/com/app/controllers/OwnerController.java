package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IBuyerDao;
import com.app.dto.LoginDTO;
import com.app.dto.PropertyBuyerLink;
import com.app.pojos.Buyer;
import com.app.pojos.LandProperty;
import com.app.pojos.Owner;
import com.app.service.IBuyerService;
import com.app.service.ILandPropertyService;
import com.app.service.IOwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	// D.I
	@Autowired
	private IOwnerService ownerService;

	@Autowired
	private ILandPropertyService landService;
	
	@Autowired
	private IBuyerService buyerService;

	public OwnerController() {
		System.out.println("in ctrl of " + getClass().getName());
	}

	// requestHandling methods
	//fetch all owners
	@GetMapping
	public ResponseEntity<?> getAllOwners() {
		System.out.println("in mapping");
		return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.CREATED);
	}
	
	// save new owner
	@PostMapping
	public ResponseEntity<?> saveOwner(@RequestBody Owner o) {
		System.out.println(o.toString());
		return new ResponseEntity<>(ownerService.saveOwner(o), HttpStatus.CREATED);
	}
	
	//validate owner login
	@PostMapping("/login")
	public ResponseEntity<?> validateOwnerLogin(@RequestBody LoginDTO owner) {
		Owner validOwner = ownerService.getOwner(owner.getEmail(), owner.getPassword());
		if(validOwner != null) 
			return new ResponseEntity<>(validOwner, HttpStatus.ACCEPTED);
		
		return new ResponseEntity<>("invalid login", HttpStatus.NOT_FOUND);
	}
	
	//fetch owner by id
	@GetMapping("/{ownerId}")
	public ResponseEntity<?> getByOwnerId(@PathVariable int ownerId) {
		return new ResponseEntity<>(ownerService.getByOwnerId(ownerId), HttpStatus.CREATED);
	}
	
	// save owner's new property
	@PostMapping("/newProperty/{ownerId}")
	public ResponseEntity<?> saveNewProperty(@RequestBody LandProperty p, @PathVariable int ownerId) {
		Owner actualOwner = ownerService.getByOwnerId(ownerId);
		actualOwner.addNewProperty(p);

		return new ResponseEntity<>(landService.saveNewProperty(p), HttpStatus.OK);
	}
	
	// get owner's all property by his id
	@GetMapping("/myProperty/{ownerId}")
	public ResponseEntity<?> getAllProperty(@PathVariable int ownerId) {
		return new ResponseEntity<>(ownerService.getByOwnerId(ownerId).getLandProperties(), HttpStatus.OK);
	}
	
	//delete owner by id
	@DeleteMapping("/delete/{ownerId}")
	public ResponseEntity<?> deleteOwner(@PathVariable int ownerId) {
		return new ResponseEntity<>(ownerService.deleteByOwnerId(ownerId), HttpStatus.OK);
	}
	
	//update owner by id
	@PutMapping("/update/{ownerId}")
	public ResponseEntity<?> updateOwner(@RequestBody Owner o, @PathVariable int ownerId) {
		// getById -> owner instance
		// owner.getterListProperty -> ListOf Proprties
		// owner.setListP
		Owner exitingO = ownerService.getByOwnerId(ownerId);
		o.setLandProperties(exitingO.getLandProperties());
		return new ResponseEntity<>(ownerService.updateOwner(o, ownerId), HttpStatus.OK);
	}
	
	// update owner's property by propId
	@PutMapping("/updateProp/{ownerId}/{propId}")
	public ResponseEntity<?> updateProperty(@PathVariable int propId,@PathVariable int ownerId ,@RequestBody LandProperty l){
		Owner o = ownerService.getByOwnerId(ownerId);
		l.setPropertyOwner(o);
		return new ResponseEntity<>(landService.updateProperty(propId, l) , HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProp/{ownerId}/{propId}")
	public ResponseEntity<?> deletePropertyById(@PathVariable int ownerId, @PathVariable int propId)
	{
		try {
			LandProperty prop = landService.fetchById(propId);
			Owner owner = ownerService.getByOwnerId(ownerId);
			System.out.println("here1");
			List<Buyer> favBuyers = landService.fetchAllFavBuyers(propId);
			System.out.println("here2");
			favBuyers.forEach(b -> {
				PropertyBuyerLink pbl = new PropertyBuyerLink();
				pbl.setBuyerId(b.getBuyerId());
				pbl.setPropertyId(propId);
			});
			System.out.println("here3");
			owner.removeProperty(prop);
			System.out.println("here4");
			return new ResponseEntity<>(landService.deletePropertyByEntity(prop), HttpStatus.ACCEPTED);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
}
