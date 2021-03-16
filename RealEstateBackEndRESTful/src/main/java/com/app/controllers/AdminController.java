package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	//D.I
	@Autowired
	private IAdminService adminService;
	
	public AdminController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	//fetch all admins
	@GetMapping
	public ResponseEntity<?> getAllAdmins()
	{
		return new ResponseEntity<>(adminService.fetchAllAdmins(), HttpStatus.OK);
	}
	
	//fetch by id
	@GetMapping("/{adminId}")
	public ResponseEntity<?> getByAdminId(@PathVariable int adminId){
		return new ResponseEntity<>(adminService.getAdminById(adminId) , HttpStatus.OK);
	}
	
	//save new admin
	@PostMapping
	public ResponseEntity<?> saveNewAdmin(@RequestBody Admin a)
	{
		return new ResponseEntity<>(adminService.saveAdmin(a), HttpStatus.OK);
	}
	
	//validate admin login
	@PostMapping("/login")
	public ResponseEntity<?> validateAdminLogin(@RequestBody LoginDTO admin){
		Admin validAdmin = adminService.adminLogin(admin.getEmail(), admin.getPassword());
		if(validAdmin != null)
			return new ResponseEntity<>(validAdmin,HttpStatus.ACCEPTED);
		
		return new ResponseEntity<>("invalid login",HttpStatus.NOT_FOUND);
	}
}
