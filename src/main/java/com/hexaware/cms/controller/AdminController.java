package com.hexaware.cms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cms.entity.Admin;
import com.hexaware.cms.service.AdminService;

@CrossOrigin("*")

@RestController
@RequestMapping("/ClaimManagementSystem")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@GetMapping("/getalladmins")
	public List<Admin> getAllAdmins(){
		return adminService.findAllAdmins();
	}
	
	@PostMapping("/addadmin")
	public String saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin) + "Admin added Successfully";
	}
		
}
