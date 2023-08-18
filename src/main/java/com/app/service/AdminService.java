package com.app.service;

import java.util.List;

import com.app.entity.Admin;

public interface AdminService {

	public List<Admin> findAllAdmin();
	public Admin findAdminById(int theId);
	public void saveAdmin(Admin theAdmin);
	public void deleteAdminById(int theId);
}
