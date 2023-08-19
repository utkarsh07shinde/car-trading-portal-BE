package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.entity.Admin;
import com.app.entity.User;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findUserById(int theId) {
		// TODO Auto-generated method stub
		Optional<User> u= userRepository.findById(theId);
		User theUser=u.get();
		return theUser;
	}

	@Override
	public void saveUser(User theUser) {
		// TODO Auto-generated method stub
		userRepository.save(theUser);
	}

	@Override
	public void deleteUserById(int theId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(theId);
	}

	@Override
	public User validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRepository.validateUser(email, password);
	}

}
