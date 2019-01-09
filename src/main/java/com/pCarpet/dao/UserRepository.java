package com.pCarpet.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pCarpet.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUsernameAndPassword(String username,String password);
}
