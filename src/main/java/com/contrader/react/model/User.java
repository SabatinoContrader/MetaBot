package com.contrader.react.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	@Column(name = "idUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	@Column(name = "username")
	@NotNull
	private String username;
	
	@Column(name = "password")
	@NotNull
	private String password;
	
	@NotNull
	@Column(name = "ruolo")
	private String ruolo;
	
	@Nullable
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn (name = "id_azienda")
	private Azienda azienda;
}
