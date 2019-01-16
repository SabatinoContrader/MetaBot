package com.contrader.react.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chatbot {

	@Id
	@Column(name = "idChatbot")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idChatbot;

	@NotNull
	@Column(name = "nomeChatbot")
	private String nomeChatbot;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	@ManyToOne()
	@JoinColumn(name = "id_nodo")
	private Nodo nodoPadre;

}
