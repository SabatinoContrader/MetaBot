package com.contrader.react.repository;

import com.contrader.react.model.Azienda;
import org.springframework.data.repository.CrudRepository;
import com.contrader.react.model.User;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    User findUserByUsernameAndPassword(String username,String password);
    List<User> findAllByUsername(String username);
    
    
    List<User> findAllByAziendaAndRuoloIsNotLike(Azienda azienda, String ruolo);
    
    List<User> findAllByRuoloIsNotLike (String ruolo);
    
    List<User> findAllByAziendaAndRuolo(Azienda azienda, String ruolo);
    
    List<User> findAllByAziendaAndRuoloIn(Azienda azienda, String[] ruoli);
}
