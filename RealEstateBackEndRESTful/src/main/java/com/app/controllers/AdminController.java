package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	//D.I
	@Autowired
	private IAdminService adminService;
	
	public AdminController() {
		System.out.println("in admin ctrl ");
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAdmins()
	{
		return new ResponseEntity<>(adminService.fetchAllAdmins(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveNewAdmin(@RequestBody Admin a)
	{
		return new ResponseEntity<>(adminService.saveAdmin(a), HttpStatus.OK);
	}
}
