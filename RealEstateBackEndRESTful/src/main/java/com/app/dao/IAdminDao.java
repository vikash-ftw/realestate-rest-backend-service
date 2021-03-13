package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Admin;

public interface IAdminDao extends JpaRepository<Admin, Integer>{
	
	// validate admin login
	@Query("select a from Admin a where a.adminEmail = :email and a.adminPassword = :password")
	Admin findByAdminEmailAndAdminPassword(String email , String password);
	
}
