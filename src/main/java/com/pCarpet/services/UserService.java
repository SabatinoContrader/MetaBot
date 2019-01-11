package com.pCarpet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pCarpet.converter.ConverterChatbot;
import com.pCarpet.converter.ConverterUser;
import com.pCarpet.dao.UserRepository;
import com.pCarpet.dto.ChatbotDTO;
import com.pCarpet.dto.UserDTO;
import com.pCarpet.model.Chatbot;
import com.pCarpet.model.User;

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
}
