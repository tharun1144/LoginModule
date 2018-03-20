package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
    	userRepository.save(user);
    	return user;
	}
    
    public Iterable<User> getUsers(){
    	return userRepository.findAll();
	}
}
