package com.contrader.react.converter;

import java.util.ArrayList;
import java.util.List;

import com.contrader.react.dto.UserDTO;
import com.contrader.react.model.User;

public class ConverterUser {
    
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO();
            userDTO.setIdUser(user.getIdUser());
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setEmail(user.getEmail());
            userDTO.setRuolo(user.getRuolo());
        }
        return userDTO;
    }
    
    public static User toEntity(UserDTO userDTO) {
        User user = null;
        if (userDTO != null) {
            user = new User();
            user.setIdUser(userDTO.getIdUser());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setRuolo(userDTO.getRuolo());
        }
        return user;
    }
    
    public static List<UserDTO> toListDTO(List<User> list) {
        List<UserDTO> listUserDTO = new ArrayList<>();
        if (!list.isEmpty()) {
            for (User user : list) {
                listUserDTO.add(ConverterUser.toDTO(user));
            }
        }
        return listUserDTO;
    }
    
    public static List<User> toListEntity(List<UserDTO> listUserDTO) {
        List<User> list = new ArrayList<>();
        if (!listUserDTO.isEmpty()) {
            for (UserDTO userDTO : listUserDTO) {
                list.add(ConverterUser.toEntity(userDTO));
            }
        }
        return list;
    }
}
