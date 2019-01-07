package com.pCarpet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pCarpet.services.NodoService;
import com.pCarpet.services.UserService;

@SpringBootApplication
public class PCarpetApplication {

	static NodoService nodoService;

	static UserService userService;

	@Autowired
	public PCarpetApplication(NodoService nodoService, UserService userService) {
		this.nodoService = nodoService;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PCarpetApplication.class, args);
	}
}
