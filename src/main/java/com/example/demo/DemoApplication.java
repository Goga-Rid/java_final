package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController
public class DemoApplication {
	@Autowired
	private UserDAO userDAO;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@GetMapping("/users")
	public List<User> getUsers() {
		return userDAO.getAllUsers();
	}


	@GetMapping("/user")
	public User getUserByName(@RequestParam String name) {
		return userDAO.getUserByName(name);
	}

}
