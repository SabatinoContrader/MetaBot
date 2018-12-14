package com.virtualpairprogrammers.model;


public class Node {
	
	private Integer id;
	private Integer id_user_fk;
	private Integer id_nodo_root_fk;
	private String name_chat;
	
	public Node (Integer id, Integer id_user_fk,Integer id_nodo_root_fk, String name_chat) {
	this.id = id;
	this.id_user_fk = id_user_fk;
	this.id_nodo_root_fk = id_nodo_root_fk;
	this.name_chat = name_chat;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_user_fk() {
		return id_user_fk;
	}

	public void setId_user_fk(Integer id_user_fk) {
		this.id_user_fk = id_user_fk;
	}

	public Integer getId_nodo_root_fk() {
		return id_nodo_root_fk;
	}

	public void setId_nodo_root_fk(Integer id_nodo_root_fk) {
		this.id_nodo_root_fk = id_nodo_root_fk;
	}

	public String getName_chat() {
		return name_chat;
	}

	public void setName_chat(String name_chat) {
		this.name_chat = name_chat;
	}
	
	
}
