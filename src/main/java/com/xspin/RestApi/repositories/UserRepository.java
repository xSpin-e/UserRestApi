package com.xspin.RestApi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xspin.RestApi.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long>{
	UserModel findByUserName(String userName);
	UserModel findByEmail(String email);
	List<UserModel> findByPhoneNumber(String phoneNumber);
}
