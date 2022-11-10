package com.hexaware.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cms.entity.Admin;
import com.hexaware.cms.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepo;

	@Override
	public List<Admin> findAllAdmins() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

}
