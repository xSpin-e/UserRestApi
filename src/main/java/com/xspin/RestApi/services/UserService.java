package com.xspin.RestApi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xspin.RestApi.models.UserModel;
import com.xspin.RestApi.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class UserService {

	
	
	@Autowired
	UserRepository userRepository;
	
	public ArrayList<UserModel> getAllUsers(){
		return (ArrayList) userRepository.findAll();
	}
	public UserModel getById(Long id) {
	    Optional<UserModel> userOptional = userRepository.findById(id);
	    if (userOptional.isPresent()) {
	        return userOptional.get(); 
	    } else {
	        throw new EntityNotFoundException("User not found by the ID: " + id);
	    }
	}
	public UserModel addUser(UserModel user) {
		
		return userRepository.save(user);
	}
	public UserModel getByUserName(String username) {
		return userRepository.findByUserName(username);
	}
	public UserModel getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public List<UserModel> getByPhoneNumber(String phoneNumber){
		return userRepository.findByPhoneNumber(phoneNumber);
	}
	public UserModel save(UserModel user) {
		return userRepository.save(user);
	}
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
}
