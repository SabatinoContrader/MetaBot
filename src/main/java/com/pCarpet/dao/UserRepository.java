package com.pCarpet.dao;

import org.springframework.data.repository.CrudRepository;
import com.pCarpet.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUsernameAndPassword(String username,String password);
	public List<User> findAllByUsername(String username);
}
