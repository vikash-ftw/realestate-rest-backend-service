package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	//D.I
	@Autowired
	private IAdminDao adminDao;
	
	public AdminServiceImpl() {
		System.out.println("in AdminService cld");
	}

	@Override
	public List<Admin> fetchAllAdmins() {
		return adminDao.findAll();
	}

	@Override
	public Admin saveAdmin(Admin a) {
		return adminDao.save(a);
	}

	@Override
	public Admin adminLogin(String email, String password) {
		return adminDao.findByAdminEmailAndAdminPassword(email, password);
	}
	
	
	
}
