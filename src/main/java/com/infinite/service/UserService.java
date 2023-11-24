package com.infinite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.infinite.model.User;
import com.infinite.repository.UserRepository;

@Service //Responsible for database interactions
public interface UserService extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findByPassword(String password);

	User findByUsernameAndPassword(String username, String password);
}
