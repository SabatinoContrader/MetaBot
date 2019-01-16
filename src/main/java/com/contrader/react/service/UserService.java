package com.contrader.react.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contrader.react.converter.ConverterUser;
import com.contrader.react.repository.UserRepository;
import com.contrader.react.dto.UserDTO;
import com.contrader.react.model.User;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<UserDTO> getListaUserDTO() {
        return ConverterUser.toListDTO((List<User>) userRepository.findAll());
    }
    
    public UserDTO getUserDTOById(Integer id) {
        return ConverterUser.toDTO(userRepository.findById(id).get());
    }
    
    public UserDTO getByUsernameAndPassword(String username, String password) {
        
        final User user = userRepository.findUserByUsernameAndPassword(username, password);
        
        return ConverterUser.toDTO(user);
    }
    
    public boolean insertUser(UserDTO userDTO) {
        return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
    }
    
    public boolean updateUser(UserDTO userDTO) {
        return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
    }
    
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
    
    public List<UserDTO> findUserDTOByUsername(String username) {
        
        final List<User> list = userRepository.findAllByUsername(username);
        final List<UserDTO> userDTOs = new ArrayList<>();
        list.forEach(i -> userDTOs.add(ConverterUser.toDTO(i)));
        return userDTOs;
        
        
    }
    //--------------------
    public UserDTO getOne(Integer id){
        return ConverterUser.toDTO(userRepository.findById(id).get());
    }
    public boolean addUser(UserDTO userDTO){
        return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
    }
    public boolean modifyUser(Integer id,UserDTO userDTO){
        UserDTO oldDTO = ConverterUser.toDTO(userRepository.findById(id).get());
        oldDTO.setUsername(userDTO.getUsername());
        oldDTO.setPassword(userDTO.getPassword());
        oldDTO.setEmail(userDTO.getEmail());
        oldDTO.setRuolo(userDTO.getRuolo());
        return userRepository.save(ConverterUser.toEntity(oldDTO)) != null;
    }
    public void deleteUser (Integer id){
        userRepository.deleteById(id);
    }
    public void deleteUser (UserDTO userDTO){
        userRepository.delete(ConverterUser.toEntity(userDTO));
    }
}
