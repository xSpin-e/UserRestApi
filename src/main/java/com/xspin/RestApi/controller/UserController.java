package com.xspin.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xspin.RestApi.models.UserModel;
import com.xspin.RestApi.repositories.UserRepository;
import com.xspin.RestApi.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<UserModel> obtenerTodosLosUsuarios() {
		return userService.getAllUsers();
	}

	@GetMapping("/id={id}")
	public UserModel getById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}

	@GetMapping("/username={userName}")
	public UserModel getByUserName(@PathVariable("userName") String userName) {
		return userService.getByUserName(userName);
	}

	@GetMapping("/email={email}")
	public UserModel getByEmail(@PathVariable("email") String email) {
		return userService.getByEmail(email);
	}

	@GetMapping("/phonenumber={phoneNumber}")
	public List<UserModel> getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
		return userService.getByPhoneNumber(phoneNumber);
	}

	@PostMapping
	public UserModel createTask(@RequestBody UserModel user) {
		return userService.save(user);
	}
	@DeleteMapping("/id={id}")
	void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}
	@PutMapping("/id={id}")
	public UserModel replaceUser(@RequestBody UserModel user, @PathVariable Long id) {
	    UserModel existingUser = userService.getById(id);

	    if (existingUser != null) {
	        existingUser.setName(user.getName());
	        existingUser.setLastName(user.getLastName());
	        existingUser.setUserName(user.getUserName());
	        existingUser.setEmail(user.getEmail());
	        existingUser.setPhoneNumber(user.getPhoneNumber());
	        existingUser.setPassword(user.getPassword());

	        return userService.save(existingUser);
	    } else {
	        return null;
	    }
	}
}
