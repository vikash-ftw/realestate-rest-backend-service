package com.app.controllers;

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

import com.app.dto.LoginDTO;
import com.app.dto.PropertyBuyerLink;
import com.app.pojos.Buyer;
import com.app.service.IBuyerService;
import com.app.service.ILandPropertyService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	//D.I
	@Autowired
	private IBuyerService buyerService;
	
	@Autowired
	private ILandPropertyService landService;
	
	public BuyerController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	// fetch all buyers
	@GetMapping
	public ResponseEntity<?> fetchAllBuyers(){
		return new ResponseEntity<>(buyerService.getAllBuyers(),HttpStatus.OK);
	}
	
	// save new buyer
	@PostMapping
	public ResponseEntity<?> saveNewBuyer(@RequestBody Buyer b){
		return new ResponseEntity<>(buyerService.registerBuyer(b), HttpStatus.OK);
	}
	
	
	//get buyer by id
	@GetMapping("/{buyerId}")
	public ResponseEntity<?> getBuyerById(@PathVariable int buyerId)
	{
		try {
			return new ResponseEntity<>(buyerService.getBuyerById(buyerId), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	// delete buyer by id
	@DeleteMapping("/delete/{buyerId}")
	public ResponseEntity<?> deleteBuyerById(@PathVariable int buyerId){
		try {
			return new ResponseEntity<>(buyerService.deleteByBuyerId(buyerId), HttpStatus.OK);
		}catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	// buyer login validation
	@PostMapping("/login")
	public ResponseEntity<?> validateBuyerLogin(@RequestBody LoginDTO b)
	{
		Buyer validBuyer = buyerService.validateBuyerLogin(b.getEmail(), b.getPassword());
		if(validBuyer != null) {
			return new ResponseEntity<>(validBuyer, HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>("invalid login", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/markFav")
	public ResponseEntity<?> markFavorite(@RequestBody PropertyBuyerLink pbl)
	{
		return new ResponseEntity<>(buyerService.markFav(pbl),HttpStatus.OK);
	}
	
	
	
	
	
}
