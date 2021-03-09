package com.app.service;

import java.util.List;

import com.app.pojos.Buyer;

public interface IBuyerService {
	
	List<Buyer> getAllBuyers();
	
	Buyer registerBuyer(Buyer b);
}
