package com.app.service;

import java.util.List;


import com.app.entity.User;

public interface UserService {

	public List<User> findAllUser();
	public User findUserById(int theId);
	public void saveUser(User theUser);
	public void deleteUserById(int theId);
	public User validateUser(String email, String password);
}
