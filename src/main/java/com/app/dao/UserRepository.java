package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User u WHERE u.username=:username and u.password=:password")
	public User validateUser(String username, String password);

}
