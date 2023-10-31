package com.xspin.RestApi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xspin.RestApi.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long>{

}
