package com.xspin.RestApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xspin.RestApi.models.UserModel;
import com.xspin.RestApi.repositories.UserRepository;
@Service
public class UserService {

	
	
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<UserModel> getAllUsers(){
		return (ArrayList) userRepository.findAll();
	}
	public UserModel addUser(UserModel user) {
		
		return userRepository.save(user);
	}
	
	
	

	
}
