package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Buyer;

public interface IBuyerDao extends JpaRepository<Buyer, Integer>{
	
	Buyer findByBuyerId(int buyerId);
	
}
