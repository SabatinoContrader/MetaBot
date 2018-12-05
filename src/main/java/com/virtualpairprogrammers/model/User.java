package com.virtualpairprogrammers.model;

import java.time.LocalDate;


public class User {
	private int idutente;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String telefono;
    private String mail;
    private String partitaiva;
    private String ruolo;

    public User(int idutente, String username, String password, String nome, String cognome, String telefono, 
    		String mail, String partitaiva, String ruolo) {
        this.idutente = idutente;
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.mail = mail;
        this.partitaiva = partitaiva;
        this.ruolo = ruolo;
    }

    public User(int idutente, String username, String nome, String cognome, String partitaiva) {
    	this.idutente=idutente;
    	this.username = username;
    	this.nome = nome;
        this.cognome = cognome;
        this.partitaiva = partitaiva;
    }
    
    
    

    public int getIdutente() {
		return idutente;
	}

    
    
	public void setIdutente(int idutente) {
		this.idutente = idutente;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getCognome() {
		return cognome;
	}





	public void setCognome(String cognome) {
		this.cognome = cognome;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	public String getMail() {
		return mail;
	}





	public void setMail(String mail) {
		this.mail = mail;
	}





	public String getPartitaiva() {
		return partitaiva;
	}





	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}





	public String getRuolo() {
		return ruolo;
	}





	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
    	
    




	@Override
    public boolean equals(Object o) {
		
		if(this==o)return true;
		if(!(this instanceof User)) return false;
		
		User u=(User)o;
		
		if(idutente==u.idutente) return true;
		
		return false;
    }

    @Override
    public int hashCode() {
        int result;
        result = nome != null ? nome.hashCode() : 0;
        result += cognome != null ? cognome.hashCode() : 0;;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "1)ID Utente: "+idutente+"\n2)Username: " + username + "\n3)Password: "+password+"\n4)Nome: " + nome + "\n5)Cognome: "+cognome+"\n6)Telefono: "+telefono+
        		"\n7)Mail: "+mail+"\n8)Partita Iva: "+partitaiva+"\n9)Ruolo: "+ruolo + "\n";

    }
    public String stampa() {
    return "\nId Utente"+idutente+"\nUsername: "+username+"\nNome: "+nome+"\nCognome: "+cognome+"\nPartita iva: "+partitaiva+"\n";
    }
}

