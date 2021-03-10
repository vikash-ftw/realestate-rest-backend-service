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

import com.app.pojos.Buyer;
import com.app.service.IBuyerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	//D.I
	@Autowired
	private IBuyerService buyerService;
	
	public BuyerController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	@GetMapping
	public ResponseEntity<?> fetchAllBuyers(){
		return new ResponseEntity<>(buyerService.getAllBuyers(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveNewBuyer(@RequestBody Buyer b){
		return new ResponseEntity<>(buyerService.registerBuyer(b), HttpStatus.OK);
	}
	
	@GetMapping("/{buyerId}")
	public ResponseEntity<?> getByOwnerID(@PathVariable int buyerId){
		return new ResponseEntity<>(buyerService.getByBuyerId(buyerId) , HttpStatus.CREATED);
	}
	
}
