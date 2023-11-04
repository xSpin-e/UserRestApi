package com.xspin.RestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xspin.RestApi.models.UserModel;
import com.xspin.RestApi.services.UserService;


@Controller
public class RegisterController {
	@Autowired
	UserService userService;

	@GetMapping("/registro") 
	public String registroHTML() {
		return "registro";
	}

	@PostMapping("/enviar-datos")
	public String obtenerRegistro(@RequestParam("name") String name, @RequestParam("lastname") String lastname, 
			@RequestParam("email") String email,
			@RequestParam("phonenumber") String phoneNumber,@RequestParam("username") String userName,
			@RequestParam("password") String password) {

		//System.out.println(name + lastname + email + phoneNumber + userName + password);
		UserModel user = new UserModel();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setLastName(lastname);
		user.setPhoneNumber(phoneNumber.replaceAll(" ", ""));
		userService.addUser(user);
	
		
		return "index";
	}

	@PostMapping("/enviar-datos-prueba")
	public String doRegister(@RequestParam("userName") String userName, @RequestParam("email") String email,
			@RequestParam("prioridad") String prioridad) {

		return "registro";
	}

}
