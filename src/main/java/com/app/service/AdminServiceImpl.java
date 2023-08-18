package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AdminRepository;
import com.app.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public List<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin findAdminById(int theId) {
		// TODO Auto-generated method stub
		Optional<Admin> a= adminRepository.findById(theId);
		Admin theAdmin=a.get();
		return theAdmin;
		
	}

	@Override
	public void saveAdmin(Admin theAdmin) {
		// TODO Auto-generated method stub
		adminRepository.save(theAdmin);
	}

	@Override
	public void deleteAdminById(int theId) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(theId);
	}

}
