package com.contrader.react.repository;

import org.springframework.data.repository.CrudRepository;
import com.contrader.react.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    User findUserByUsernameAndPassword(String username,String password);
    List<User> findAllByUsername(String username);
}
