package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public List<User> list() {
		return userService.listAllUser();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User get(@PathVariable Integer id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "user", method = RequestMethod.POST)
	public void add(@RequestBody User user) {
		userService.saveUser(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody User user, @PathVariable Integer id) {
		User existUser = userService.getUser(id);
		user.setId(id);
		userService.saveUser(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {

		userService.deleteUser(id);
	}
}
