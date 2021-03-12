package com.app.service;

import java.util.List;

import com.app.dto.PropertyBuyerLink;
import com.app.pojos.Buyer;

public interface IBuyerService {
	
	List<Buyer> getAllBuyers();
	
	Buyer registerBuyer(Buyer b);
	
	Buyer getBuyerById(int buyerId);
	
	Buyer deleteByBuyerId(int buyerId);
	
	Buyer validateBuyerLogin(String email, String password);
	
	String markFav(PropertyBuyerLink pbl);
}
