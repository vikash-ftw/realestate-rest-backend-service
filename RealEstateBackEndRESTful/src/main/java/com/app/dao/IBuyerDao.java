package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Buyer;

public interface IBuyerDao extends JpaRepository<Buyer, Integer>{
	
	@Query("select b from Buyer b where b.buyerEmail=?1 and b.buyerPassword=?2")
	Buyer validateBuyerLogin(String email, String password);
}
