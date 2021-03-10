package com.app.service;

import java.util.List;

import com.app.pojos.Admin;

public interface IAdminService {
	
	//fetch all admins
	List<Admin> fetchAllAdmins();
	
	//save new admin
	Admin saveAdmin(Admin a);
	
}
