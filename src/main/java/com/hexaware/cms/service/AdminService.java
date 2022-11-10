package com.hexaware.cms.service;

import java.util.List;

import com.hexaware.cms.entity.Admin;

public interface AdminService {
	public List<Admin> findAllAdmins();
	public Admin saveAdmin(Admin admin);

}
