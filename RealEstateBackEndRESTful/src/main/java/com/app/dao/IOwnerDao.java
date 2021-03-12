package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Buyer;
import com.app.pojos.Owner;

public interface IOwnerDao extends JpaRepository<Owner, Integer> {
	
	@Query("select o from Owner o where o.ownerEmail = :email and o.ownerPassword = :password")
	Owner findByOwnerEmailAndOwnerPassword(String email , String password);
	
	Owner findByOwnerId(int ownerId);
	
	Owner deleteByOwnerId(int ownerId);
}
