package com.klef.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.model.User;
import com.klef.repository.UserRepository;



@Service
public class UserManager {
	
	@Autowired
	UserRepository UR;
	public String login(User U) {
		try {
			if (UR.validateLogin(U.getUsername(), U.getPassword()) > 0)
                return "Login successful";
            else
                throw new Exception("Invalid username or password!");
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
	
	 public User authenticateUser(String username, String password) {
	        // Simulate a database lookup
	        if ("johndoe".equals(username) && "1234".equals(password)) {
	            // Admin user
	            return new User(username, password, "admin");
	        } else if ("user".equals(username) && "user123".equals(password)) {
	            // Regular user
	            return new User(username, password, "user");
	        } else {
	            // Invalid credentials
	            return null;
	        }

	 }
}