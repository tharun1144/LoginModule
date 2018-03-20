package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/signup")
	public String addUser(@RequestParam String fullName, @RequestParam String userName, @RequestParam String password) throws Exception {
        User user = new User(fullName, userName, password);
		user = userService.addUser(user);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password) throws Exception {
		for(User user : userRepository.findAll()) {
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return "/display";
			}
		}
        return "redirect:/";
	}
	
	@RequestMapping("/display")
	public void diplay() throws Exception {
	}
}
