package com.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	//D.I
	
	public OwnerController() {
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	// requestHandling methods
}
