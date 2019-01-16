package com.contrader.react.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatbotDTO {

	private Integer idChatbot;
	private String nomeChatbot;
	private UserDTO user;
	private NodoDTO nodoPadre;
}
