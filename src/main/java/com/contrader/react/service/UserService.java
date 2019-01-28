package com.contrader.react.service;

import java.util.ArrayList;
import java.util.List;

import com.contrader.react.converter.ConverterAzienda;
import com.contrader.react.dto.AziendaDTO;
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
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<UserDTO> getListaUserDTO () {
        return ConverterUser.toListDTO((List<User>) userRepository.findAll());
    }
    
    public UserDTO getUserDTOById (Integer id) {
        return ConverterUser.toDTO(userRepository.findById(id).get());
    }
    
    public UserDTO getByUsernameAndPassword (String username, String password) {
        return ConverterUser.toDTO(userRepository.findUserByUsernameAndPassword(username, password));
    }
    
    
    public List<UserDTO> findUserDTOByUsername (String username) {
        return ConverterUser.toListDTO(userRepository.findAllByUsername(username));
    }
    
    //--------------------
    public UserDTO getOne (Integer id) {
        return ConverterUser.toDTO(userRepository.findById(id).get());
    }
    
    public boolean addUser (UserDTO userDTO) {
        return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
    }
    
    public boolean modifyUser (Integer id, UserDTO userDTO) {
        UserDTO oldDTO = ConverterUser.toDTO(userRepository.findById(id).get());
        oldDTO.setUsername(userDTO.getUsername());
        oldDTO.setPassword(userDTO.getPassword());
        oldDTO.setEmail(userDTO.getEmail());
        oldDTO.setRuolo(userDTO.getRuolo());
        return userRepository.save(ConverterUser.toEntity(oldDTO)) != null;
    }
    
    public boolean deleteUser (Integer id) {
        userRepository.deleteById(id);
        return userRepository.existsById(id);
    }
    
    public void deleteUser (UserDTO userDTO) {
        userRepository.delete(ConverterUser.toEntity(userDTO));
    }

    public List<UserDTO> findAllByAziendaAndRuoloIsNotLike (AziendaDTO aziendaDTO, String ruolo){
        return ConverterUser.toListDTO(userRepository.findAllByAziendaAndRuoloIsNotLike(ConverterAzienda.toEntity(aziendaDTO), ruolo));
    }
    
    public List<UserDTO> findAllByRuoloIsNotLike (String ruolo) {
        return ConverterUser.toListDTO(userRepository.findAllByRuoloIsNotLike(ruolo));
    }
    
    public List<UserDTO> findAllByAziendaAndRuolo (AziendaDTO aziendaDTO, String ruolo){
        return ConverterUser.toListDTO(userRepository.findAllByAziendaAndRuolo(ConverterAzienda.toEntity(aziendaDTO),ruolo));
    }
    public List<UserDTO> findAllByAziendaAndRuoloIn(AziendaDTO aziendaDTO, String[] ruoli){
        return ConverterUser.toListDTO(userRepository.findAllByAziendaAndRuoloIn(ConverterAzienda.toEntity(aziendaDTO),ruoli));
    }

}
