package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.dto.PropertyBuyerLink;
import com.app.pojos.Buyer;
import com.app.pojos.LandProperty;

public interface IBuyerService {
	
	List<Buyer> getAllBuyers();
	
	Buyer registerBuyer(Buyer b);
	
	Buyer getBuyerById(int buyerId);
	
	Buyer deleteByBuyerId(int buyerId);
	
	Buyer validateBuyerLogin(String email, String password);
	
	Buyer updateBuyerById(Buyer b, int buyerId);
	
	String markFav(PropertyBuyerLink pbl);
	
	String unFav(PropertyBuyerLink pbl);
	
	Set<LandProperty> grabAllfav(int buyerId);
	
}
